package examples;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
public class Example2 extends Application{
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        Button btn = new Button("Click me for event! hehe");

//        setting mouse event
        btn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                System.out.println("Daddy clicked me");
            }
        });

//        instantiate stack pane
        StackPane root = new StackPane();
        root.getChildren().add( btn );

//        setting scene
        Scene scene = new Scene(root, 500, 300);
        stage.setTitle("Mouse event click");
        stage.setScene(scene);
        stage.show();
    }
}
