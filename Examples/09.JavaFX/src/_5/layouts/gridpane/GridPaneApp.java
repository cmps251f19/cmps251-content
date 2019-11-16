package _5.layouts.gridpane;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GridPaneApp extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("gridpane.fxml"));
        primaryStage.setTitle("GridPane Demo App");
        primaryStage.setScene(new Scene(root, 400, 240));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}