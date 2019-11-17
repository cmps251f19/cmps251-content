package _8.binding.studentapp;

import java.text.NumberFormat;

import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class StudentController {
	private Student student;
	
    @FXML
    private DialogPane dialogPane;
    
    @FXML
    private TextField idField;

    @FXML
    private TextField firstNameField;

    @FXML
    private TextField lastNameField;

    @FXML
    private TextField emailField;
    
    //Called by the Main controller to pass a student object to dialog box
    public void setStudent(Student student) {
    	this.student = student;
    	
    	//Bind the student properties to the UI controls 
    	idField.textProperty().bindBidirectional(student.idProperty(), 
    			NumberFormat.getNumberInstance());
    	firstNameField.textProperty().bindBidirectional(student.firstNameProperty());
    	lastNameField.textProperty().bindBidirectional(student.lastNameProperty());
    	emailField.textProperty().bindBidirectional(student.emailProperty());
    	
    	//Validate before allowing the user to ok
    	Button okButton = (Button)dialogPane.lookupButton(ButtonType.OK);
    	okButton.addEventFilter(
    		ActionEvent.ACTION, event -> {
    			if (!validateFormData()) {
    				// Validation failed -> prevent the dialog to close
    				event.consume();
    			}
    	});
    }
    
    private boolean validateFormData() {
        if(idField.getText().isEmpty() || idField.getText().equals("0")) {
            showAlert(AlertType.ERROR, "Form Error!",
                    "Please enter the Student Id");
            idField.requestFocus();
            return false;
        }
        
        if(firstNameField.getText().isEmpty()) {
            showAlert(AlertType.ERROR, "Form Error!",
                    "Please enter the student first name");
            firstNameField.requestFocus();
            return false;
        }
        
        if(lastNameField.getText().isEmpty()) {
            showAlert(AlertType.ERROR, "Form Error!",
                    "Please enter the student last name");
            lastNameField.requestFocus();
            return false;
        }
        
        if(emailField.getText().isEmpty()) {
            showAlert(AlertType.ERROR, "Form Error!",
                    "Please enter the student email");
            emailField.requestFocus();
            return false;
        }
        
        return true;
    }
    
	private void showAlert(AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.show();
    }   
}