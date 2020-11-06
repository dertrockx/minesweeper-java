package examples;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class HelloWorld {
    private Scene scene;
    private StackPane root;

    public HelloWorld(){
        this.root = new StackPane();
        this.scene = new Scene(root, 500, 300);
    }

    public void setStageComponents(Stage stage){
        Button btn = new Button("Click me!");

        btn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                System.out.println("Daddy clicked me while inside hello world!");
            }
        });

//        add components to root stack
        this.root.getChildren().add( btn );

        stage.setTitle("Hello world with extra shemes");
        stage.setScene(this.scene);
        stage.show();
    }
}
