package examples;
import javafx.application.Application;

import javafx.stage.Stage;

public class Example extends Application{
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        HelloWorld gameStage = new HelloWorld();
        gameStage.setStageComponents(stage);
    }
}
