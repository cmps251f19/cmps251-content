package _9.mvapp.surah;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SurahApp extends Application {

    @Override
    public void start(Stage stage) throws Exception{
        Pane root = FXMLLoader.load(getClass().getResource("SurahView.fxml"));
        stage.setScene(new Scene(root, 600, 500));
        stage.setTitle("Surah App");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
