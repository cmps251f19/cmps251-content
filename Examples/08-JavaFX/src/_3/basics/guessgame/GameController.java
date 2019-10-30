package _3.basics.guessgame;

import java.util.Optional;

import javax.swing.JOptionPane;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * The controller receives events and input from the UI
 * and updates the UI.
 * When an event occurs, the controller get the input data from 
 * the view UI elements and pass them to method calls of the model.
 * It gets results from the model and pass them to the view to display them.
 * 
 * A controller has the logic for the UI, but not the application logic.
 * 
 * In a JavaFX app, the controller needs a way access some
 * UI components, such as reading text from an input field.
 * The controller refers to JavaFX components by
 * defining attributes annotated with @FXML.  The names of the
 * attributes must be exactly the same as names of UI components
 * that you assign to fx:id when you create the UI using SceneBuilder.
 */
public class GameController {
	/** Reference to the game we are playing. */
	private GameModel game;
	
    @FXML
    private Label guessMessageLabel;
    
    @FXML
    private TextField guessTextField;

    @FXML
    private Button submitButton;

    @FXML
    private Button cancelButton;

    @FXML
    private Label statusMessageLabel;

	/**
	 * JavaFX calls the initialize() method of your controller when
	 * it creates the UI form, after the components have been created
	 * and @FXML annotated attributes have been set.
	 * 
	 * This is a hook to initialize anything your controller or UI needs.
	 */
	@FXML
	public void initialize() {
		game = new GameModel();
		System.out.println("GameController initializing");
		// display a hint from the model
		guessMessageLabel.setText(game.getMessage());
		statusMessageLabel.setText("");
	}
	
	/**
	 * Handle event triggered by submitButton press.
	 * @param event a javafx.event.ActionEvent containing info about the event source
	 *     and type of event.
	 */
    @FXML 
    void handleSubmit(ActionEvent event) {
		statusMessageLabel.setText("");

		String input = guessTextField.getText().trim();
		guessTextField.setText("");
		
		if (!isValidGuess(input)) {
			return;
		}
		
		//More info about dialogs @ https://code.makery.ch/blog/javafx-dialogs-official/
		// Game is over. What to do now?
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Confirmation Dialog");
		alert.setHeaderText("Right! You guessed the secret number.");
		alert.setContentText("Play again?");

		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() != ButtonType.OK) {
			Platform.exit();
		}
		
		// create a new game and get hint
		int upperBound = 2 * game.getUpperBound();
		game = new GameModel(upperBound);
		guessMessageLabel.setText(game.getMessage());
		statusMessageLabel.setText("");
	}
	
	/**
	 * Handle event triggered by clearButton press.
	 * @param event a javafx.event.ActionEvent containing info about the event source
	 *     and type of event.
	 */
    @FXML
    void handleCancel(ActionEvent event) {
		Platform.exit();
	}
	
    private boolean isValidGuess(String input) {
		if (input.isEmpty()) {
			guessTextField.requestFocus();
			statusMessageLabel.setText("Please enter a number");
			return false;
		}
		
		int guess;
		try {
			guess = Integer.parseInt(input);
		} catch (NumberFormatException nfe) {
			statusMessageLabel.setText("Invalid input");
			return false;
		}
		
		boolean ok = game.evaluateGuess( guess );
		statusMessageLabel.setText(game.getMessage());
		if (! ok ) {
			guessTextField.requestFocus();
			return false;
		}
		return true;
    }
}