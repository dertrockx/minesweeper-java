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

        this.gameBoard = new int[GameStage.MAP_NUM_ROWS][GameStage.MAP_NUM_COLS];
    }

    //method to add the stage elements
    public void setStage(Stage stage) {
        this.stage = stage;
        //draw the background to the canvas at location x=0, y=70
        this.gc.drawImage( this.bg, 0, 70);

        this.initGameBoard();

        //set stage elements here
        this.root.getChildren().add(canvas);
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
    private void drawBoard(){
        for(int i = 0; i < GameStage.MAP_NUM_ROWS; i++){
            for(int j = 0; i < GameStage.MAP_NUM_COLS; j++){

            }
        }
    }
    // implement the necessary getters and setters

    // add implementation of changing from GameStage to GameOverStage


}

