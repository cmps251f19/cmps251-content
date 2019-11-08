package lab12.country;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CountryApp extends Application {

    @Override
    public void start(Stage stage) throws Exception{
        Pane root = FXMLLoader.load(getClass().getResource("CountryView.fxml"));
        stage.setScene(new Scene(root, 800, 500));
        stage.setTitle("Country App");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
