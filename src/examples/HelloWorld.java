package examples;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HelloWorld {
    private Scene scene;
    private VBox root;

    public HelloWorld(){
        this.root = new VBox();
        this.scene = new Scene(root, 500, 300);
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
