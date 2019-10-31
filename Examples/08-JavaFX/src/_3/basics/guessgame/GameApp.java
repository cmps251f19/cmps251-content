package _3.basics.guessgame;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Main class for starting the application.
 * Initialize the application and display first scene of the UI.
 * Use this class to create and initialize any objects your app needs.
 */
public class GameApp extends Application {
	/**
	 * Select the scene to display and start JavaFX.
	 * This is a call-back method invoked by JavaFX.  
	 * Your main method calls Application.launch() and JavaFX
	 * calls this method to show a "scene".
	 * 
	 * @param stage the primary "stage" for showing the scene.
	 */
	@Override
	public void start(Stage stage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("GameView.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Guessing Game");
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
