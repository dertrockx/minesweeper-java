package examples;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

public class GameStage {
    private Scene scene;
    private Stage stage;
    /*Group layout/container is a component which applies no special
    layout to its children. All child components (nodes) are positioned at 0,0*/
    private Group root;
    private Canvas canvas;
    private GraphicsContext gc;

    private int[][] gameBoard;
    private GridPane map;
    private boolean isFlagClicked = false;
    private ArrayList<Element> landElements;

    private Element flag;

    public final static int MAX_CELLS = 9;
    public final static int MAP_NUM_ROWS = 3;
    public final static int MAP_NUM_COLS = 3;
    public final static int MAP_WIDTH = 400;
    public final static int MAP_HEIGHT = 400;
    public final static int CELL_WIDTH = 115;
    public final static int CELL_HEIGHT = 115;
    public final static int FLAG_WIDTH = 70;
    public final static int FLAG_HEIGHT = 70;
    public final static boolean IS_GAME_DONE = false;
    public final static int WINDOW_WIDTH = 500;
    public final static int WINDOW_HEIGHT = 500;

    public final Image bg = new Image("images/background.jpg",500,500,false,false);

    public GameStage() {
        this.root = new Group();
        this.scene = new Scene(root, GameStage.WINDOW_WIDTH,GameStage.WINDOW_HEIGHT,Color.WHITE);
        this.canvas = new Canvas(GameStage.WINDOW_WIDTH,GameStage.WINDOW_HEIGHT);
        this.gc = canvas.getGraphicsContext2D();
        this.flag = new Element(Element.FLAG_TYPE, this);
        this.gameBoard = new int[GameStage.MAP_NUM_ROWS][GameStage.MAP_NUM_COLS];
        this.landElements = new ArrayList<>();
        this.map = new GridPane();
    }

    //method to add the stage elements
    public void setStage(Stage stage) {
        this.stage = stage;
        //draw the background to the canvas at location x=0, y=70
        this.gc.drawImage( this.bg, 0, 70);

        this.initGameBoard();
        this.drawMap();

        //set stage elements here
        this.root.getChildren().add(canvas);
        this.root.getChildren().add(map);
        this.root.getChildren().add(this.flag.getImageView());
        this.stage.setTitle("Modified Minesweeper Game");
        this.stage.setScene(this.scene);
        this.stage.show();
    }

    // place your implementation of the game here; the game logic and the layout
//    initialize game board
    private void initGameBoard(){
        Random rand = new Random();
        for(int i = 0;i < GameStage.MAP_NUM_ROWS; i++){
            for(int j = 0; j < GameStage.MAP_NUM_COLS; j++){
                this.gameBoard[i][j] = rand.nextInt(2);
            }
        }
//        prints the board
        for(int i = 0; i < GameStage.MAP_NUM_ROWS; i++){
            System.out.println(Arrays.toString( this.gameBoard[i] ));
        }
    }

//    draw the game baord
    private void drawMap(){
        for(int i = 0; i < GameStage.MAP_NUM_ROWS; i++){
            for(int j = 0; j < GameStage.MAP_NUM_COLS; j++){
                Element el = new Element(Element.LAND_TYPE, this);
                el.initRowCol(i, j);
                this.landElements.add(el);
            }
        }

        this.setGridPaneProps();
        this.setGridPaneContent();
    }

    private void setGridPaneProps(){
//        set preferred size of map gridpane
        try {
            this.map.setPrefSize(GameStage.MAP_WIDTH, GameStage.MAP_HEIGHT);

            this.map.setLayoutX( GameStage.WINDOW_WIDTH * 0.15 );
            this.map.setLayoutY( GameStage.WINDOW_HEIGHT * 0.15 );
//        vertical padding
            this.map.setVgap(5);
//        horizontal padding
            this.map.setHgap(5);
        } catch(Exception e){
            System.out.println(e.getMessage());
        }

    }

    private void setGridPaneContent(){
        int counter = 0;

        for(int row = 0; row < GameStage.MAP_NUM_ROWS; row++){
            for(int col = 0; col < GameStage.MAP_NUM_COLS; col++){
                GridPane.setConstraints( landElements.get(counter).getImageView(), col, row );
                counter++;
            }
        }

        for(Element landEl: this.landElements){
            this.map.getChildren().add( landEl.getImageView() );
        }
    }

    public boolean isFlagClicked() {
        return this.isFlagClicked;
    }

    public void setFlagClicked(boolean value) {
        this.isFlagClicked = value;
    }

    public boolean isBomb(Element el){
        int i = el.getRow(), j = el.getCol();

        if( this.gameBoard[i][j] == 1 ){
            System.out.println(">>>>>>>>>>>> BOMB!!!");
            return true;
        }
        System.out.println(">>>>>>>>>>>>>> SAFE!!!");
        return false;
    }


    public void flashGameOver() {
        PauseTransition transition = new PauseTransition(Duration.seconds(1));
        transition.play();

        transition.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                GameOverStage gameOver = new GameOverStage();
                stage.setScene(gameOver.getScene());
            }
        });
    }
}

