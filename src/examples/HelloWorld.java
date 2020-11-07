package examples;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class HelloWorld {
    private Scene scene;
    private Stage stage;
    private Group root;
    private Canvas canvas;
    private GraphicsContext gc;
    private Image poro;
    private Image buiscuit;
    private int poroXpos;
//    private VBox root;

    public HelloWorld(){
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
        this.buiscuit = new Image("images/buiscuit.png", 50, 50, false, false);
        this.poroXpos = 150;
    }

    public void setStage(Stage stage) {
        this.stage = stage;

//        set stage elements
        this.root.getChildren().add( canvas );
        this.stage.setTitle("The first Game Application");
        this.stage.setScene( this.scene );
        this.stage.show();
    }



    public void setStageComponents(Stage stage){
//        Button btn = new Button("Click me!");
//
//        btn.setOnMouseClicked(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent mouseEvent) {
//                System.out.println("Daddy clicked me while inside hello world!");
//            }
//        });
//
////        add components to root stack
//        this.root.getChildren().add( btn );

        Button clickMe = new Button("Click me daddy");
        Button exit = new Button("Close the door when you leave");

        clickMe.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                handleButtonClick("clickMe");
            }
        });

        exit.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                handleButtonClick("exit");
            }
        });


        this.root.getChildren().add( clickMe );
        this.root.getChildren().add( exit );

        stage.setTitle("Hello world with extra shemes");
        stage.setScene(this.scene);
        stage.show();
    }

    private void handleButtonClick(String btnName) {
        if(btnName.contentEquals("clickMe")){
            System.out.println("Daddy clicked me with a twist");
        } else {
            System.out.println("End of program! Byeeee");
            System.exit(0);
        }
    }
}
