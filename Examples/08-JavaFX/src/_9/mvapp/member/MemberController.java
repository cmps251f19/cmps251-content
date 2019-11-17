package _9.mvapp.member;

import java.text.NumberFormat;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class MemberController {
	Member member = null;
	
    @FXML
    private DialogPane dialogPane;
    
    @FXML
    private GridPane gridPane;
    
    @FXML
    private TextField idField;

    @FXML
    private TextField firstNameField;

    @FXML
    private TextField lastNameField;

    @FXML
    private TextField emailField;
    
    @FXML
    private TextField gpaField;

    @FXML
    private TextField officeField;
    
    //Called by the Main controller to pass a student object to dialog box
    public void setMember(Member member) {
    	this.member = member;
    	//Bind the student properties to the UI controls 
    	idField.textProperty().bindBidirectional(member.idProperty(), 
    			NumberFormat.getNumberInstance());
    	firstNameField.textProperty().bindBidirectional(member.firstNameProperty());
    	lastNameField.textProperty().bindBidirectional(member.lastNameProperty());
    	emailField.textProperty().bindBidirectional(member.emailProperty());
    	
    	if (member instanceof Student) {
    		gpaField.textProperty().bindBidirectional(((Student)member).gpaProperty(), NumberFormat.getNumberInstance());
    		//Remove the gridPane row showing the office
    		Integer rowToRemove = GridPane.getRowIndex(officeField);
    		gridPane.getChildren().removeIf(node -> rowToRemove.equals( GridPane.getRowIndex(node)) );
    	}
    	
    	if (member instanceof Faculty) {
    		officeField.textProperty().bindBidirectional(((Faculty)member).officeProperty());
    		//Remove the gridPane row showing the gpa
    		Integer rowToRemove = GridPane.getRowIndex(gpaField);
    		gridPane.getChildren().removeIf(node -> rowToRemove.equals( GridPane.getRowIndex(node)) );
    	}
    	
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
                    "Please enter the first name");
            firstNameField.requestFocus();
            return false;
        }
        
        if(lastNameField.getText().isEmpty()) {
            showAlert(AlertType.ERROR, "Form Error!",
                    "Please enter the last name");
            lastNameField.requestFocus();
            return false;
        }
        
        if(emailField.getText().isEmpty()) {
            showAlert(AlertType.ERROR, "Form Error!",
                    "Please enter the email");
            emailField.requestFocus();
            return false;
        }
        
    	if (member instanceof Student) {
    	       if(gpaField.getText().isEmpty() || gpaField.getText().equals("0")) {
    	            showAlert(AlertType.ERROR, "Form Error!",
    	                    "Please enter the gpa");
    	            gpaField.requestFocus();
    	            return false;
    	        }
    	}
        
    	if (member instanceof Faculty) {
 	       if(officeField.getText().isEmpty()) {
 	            showAlert(AlertType.ERROR, "Form Error!",
 	                    "Please enter the faculty office");
 	           officeField.requestFocus();
 	            return false;
 	        }
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