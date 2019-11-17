package _5.layouts.borderpane;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BorderPaneApp extends Application {

	/*
	See Tips for Sizing and Aligning Nodes
		* https://docs.oracle.com/javafx/2/layout/size_align.htm
	Watch JavaFX Scene Builder Tutorial - Make GUI Responsive: 
		* https://www.youtube.com/watch?v=fl6Wp1I9wHQ
		* https://www.youtube.com/watch?v=Z1W4E2d4Yxo
	*/
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("borderpane.fxml"));
        primaryStage.setTitle("BorderPane Demo App");
        primaryStage.setScene(new Scene(root, 800, 500));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
