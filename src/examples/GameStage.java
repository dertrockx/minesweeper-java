package examples;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class GameStage {
    private Scene scene;
    private Stage stage;
    private Group root;
    private Canvas canvas;
    private GraphicsContext gc;
//    private ImageView poro;
//    private ImageView biscuit;
    private Image poro;
    private Image biscuit;
    private int poroXpos;
//    private VBox root;

    public GameStage(){
//        this.root = new VBox();
//        this.scene = new Scene(root, 500, 300);
        this.root = new Group();

//        create a 400 x 400 application with black background
        this.scene = new Scene(root, 400, 400, Color.BLACK);
//        create a 400 x 400 canvas for "drawing" element
        this.canvas = new Canvas(400, 400);
        this.gc = canvas.getGraphicsContext2D();

//        to resize image upon loading
        this.poro = new Image("images/poro.png", 120, 120, false, false);
        this.biscuit = new Image("images/biscuit.png", 50, 50, false, false);
//        this.poro = new ImageView("images/poro.png" );
//        this.buiscuit = new ImageView("images/biscuit.png");
        this.poroXpos = 150;
    }

    public void setStage(Stage stage) {
        this.stage = stage;

        this.addComponents();
        this.handleKeyPressEvent();
//        set stage elements
        this.root.getChildren().add( canvas );
        this.stage.setTitle("The first Game Application");
        this.stage.setScene( this.scene );
        this.stage.show();


    }

    private void addComponents(){
        gc.clearRect(0,0,400,400);
//        sets font style
        Font theFont = Font.font("Ubuntu", FontWeight.BOLD, 30);
        this.gc.setFill(Color.PINK);

        this.gc.setFont( theFont );
//        add a "hello world" to location x=60, y=50
        this.gc.fillText("Hello World", 60, 50);
        this.gc.setFill(Color.GREEN);

        this.gc.fillText("First GUI Example", 60, 120);
        //to load the image; original size
//        Image poro = new Image("images/poro.png");
//        gc.drawImage(poro, 150, 150);
        this.gc.drawImage(poro, this.poroXpos, 150);
        this.gc.drawImage(biscuit, 300, 200);
    }

    private void handleKeyPressEvent(){
//        TODO: Add setOnKeyPress() event handler here
        this.scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if(keyEvent.getCode() == KeyCode.RIGHT){
                    setDx(10);
                    System.out.println("Move right!");
                } else if(keyEvent.getCode() == KeyCode.LEFT){
                    setDx(-10);
                    System.out.println("Move left");
                }
            }
        });
    }

    private void setDx(int dx){
//        TODO: CHANGE x position of poro here and redraw canvas components
        this.poroXpos += dx;
//         since components are not reactive
//        you have to manually reload the components
        this.addComponents();
    }




}