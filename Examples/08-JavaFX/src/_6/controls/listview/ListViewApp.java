package _6.controls.listview;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ListViewApp extends Application {

    @Override
    public void start(Stage stage) throws Exception{
        Pane root = FXMLLoader.load(getClass().getResource("ListView.fxml"));
        stage.setScene(new Scene(root, 800, 500));
        stage.setTitle("ListView App");
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
