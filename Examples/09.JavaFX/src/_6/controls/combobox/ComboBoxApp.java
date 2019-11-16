package _6.controls.combobox;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ComboBoxApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Pane root = FXMLLoader.load(getClass().getResource("ComboBox.fxml"));
        stage.setScene(new Scene(root, 500, 200));
        stage.setTitle("ComboBox App");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}