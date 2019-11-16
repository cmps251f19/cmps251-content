package _3.basics.gettime;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class TimeApp extends Application {
    @Override
    public void start(Stage stage) throws Exception {
    	String viewFileName = "TipView.fxml";
    	String windowTite = "Tip App";
    	Pane root = FXMLLoader.load(getClass().getResource(viewFileName));
        stage.setTitle(windowTite);
        stage.setScene(new Scene(root, 400, 300));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}