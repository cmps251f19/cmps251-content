package _6.controls.tableview;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TableViewApp extends Application {

    @Override
    public void start(Stage stage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("tableview.fxml"));
        stage.setScene(new Scene(root, 800, 500));
        stage.setTitle("TableView App");
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
