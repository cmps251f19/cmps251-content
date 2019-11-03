package _5.layouts.flowpane;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FlowPaneApp extends Application {
    @Override
    public void start(Stage stage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("flowpane.fxml"));
        stage.setTitle("FlowPane Demo App");
        stage.setScene(new Scene(root, 800, 500));
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
