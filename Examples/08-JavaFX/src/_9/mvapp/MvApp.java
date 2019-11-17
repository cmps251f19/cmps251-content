package _9.mvapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MvApp extends Application {

    @Override
    public void start(Stage stage) throws Exception{
        Pane root = FXMLLoader.load(getClass().getResource("MainView.fxml"));
        stage.setScene(new Scene(root, 800, 500));
        stage.setTitle("Multi Views App");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
