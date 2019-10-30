package _4.dialogs;

import java.util.List;
import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;

//More info @ https://code.makery.ch/blog/javafx-dialogs-official/
public class DialogsController {

	@FXML
	private Label messageLabel;

	@FXML
	void handleInformationDialog(ActionEvent event) {
		showInformationDialog();
	}
	
	@FXML
	void handleErrorDialog(ActionEvent event) {
		showErrorDialog();
	}
	
	@FXML
	void handleConfirmationDialog(ActionEvent event) {
		Optional<ButtonType> isConfirmed = showConfirmationDialog();
		if (isConfirmed.get() == ButtonType.OK){
			messageLabel.setText("User selected ok"); 
		} else {
			messageLabel.setText("User selected cancel"); 
		}
	}

	@FXML
	void handleTextInputDialog(ActionEvent event) {
		Optional<String> username = getUsername(); 
		username.ifPresent( name -> 
			messageLabel.setText(String.format("Username: %s", name)) 
		);
	}
	
	@FXML
	void handleChoiceDialog(ActionEvent event) {
		Optional<Book> selectedBook = getBookChoice();
		selectedBook.ifPresent( book -> 
			messageLabel.setText(String.format("Selected book: %s", book.getName())) 
		);
	}
	
	private void showInformationDialog()
	{
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Information Dialog");
		alert.setHeaderText("Look, an Information Dialog");
		alert.setContentText("I have a great message for you!");
		alert.showAndWait();
	}
	
	private void showErrorDialog()
	{
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Error Dialog");
		alert.setHeaderText("Error Opening students.json file");
		alert.setContentText("Attention!\n" +
			"There was an error opening the students.json file\n" +
			"Make sure the file exists and try again");
		alert.showAndWait();
	}
	
	private Optional<ButtonType> showConfirmationDialog() {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Confirmation Dialog");
		alert.setHeaderText("Look, a Confirmation Dialog");
		alert.setContentText("Are you ok with this?");

		return alert.showAndWait();
	}
	
	
	private Optional<String> getUsername()
	{
		TextInputDialog dialog = new TextInputDialog();
		dialog.setTitle("Name input dialog");
		dialog.setHeaderText("Enter your name");		
		return dialog.showAndWait();
	}
	
    private Optional<Book> getBookChoice() {
        Book java = new Book(1, "J01", "Java Tutorial for Beginners");
        Book csharp = new Book(2, "C01", "CSharp Tutoral for Beginners");
        Book python = new Book(3, "P01", "Python for Beginners");
 
        List<Book> books = List.of(java, csharp, python);
        Book defaultBook = csharp;
 
        ChoiceDialog<Book> dialog = new ChoiceDialog<Book>(defaultBook, books);
 
        dialog.setTitle("Book Selection");
        dialog.setHeaderText("Select a Book:");
        dialog.setContentText("Book:");
 
        return dialog.showAndWait();
    }
}