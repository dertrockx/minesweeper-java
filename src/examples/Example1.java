package examples;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
public class Example1 extends Application{
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        Button btn = new Button("Click me daddy!");
        StackPane root = new StackPane();

        root.getChildren().add( btn );

        Scene scene = new Scene(root, 500, 300);
        stage.setTitle("Hello World App!");
        stage.setScene(scene);
        stage.show();
    }
}
