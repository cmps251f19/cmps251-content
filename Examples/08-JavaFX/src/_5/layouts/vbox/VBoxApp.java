package _5.layouts.vbox;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class VBoxApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("vbox.fxml"));
        primaryStage.setTitle("HBox Demo App");
        primaryStage.setScene(new Scene(root, 500, 240));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
