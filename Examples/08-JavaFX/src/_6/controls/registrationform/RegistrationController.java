package _6.controls.registrationform;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;

public class RegistrationController {
    @FXML
    private TextField firstNameTextField;

    @FXML
    private TextField lastNameTextField;

    @FXML
    private TextField emailTextField;
    
    @FXML
    private ComboBox<String> titleComboBox;

    @FXML
    private ListView<String> degreesList;

    @FXML
    private ComboBox<String> universitiesComboBox;

    @FXML
    void handleSave(ActionEvent event) {
        if(firstNameTextField.getText().isEmpty()) {
            showAlert(AlertType.ERROR, "Form Error!",
                    "Please enter your first name");
            firstNameTextField.requestFocus();
            return;
        }
        
        if(lastNameTextField.getText().isEmpty()) {
            showAlert(AlertType.ERROR, "Form Error!",
                    "Please enter your last name");
            lastNameTextField.requestFocus();
            return;
        }
        if(emailTextField.getText().isEmpty()) {
            showAlert(AlertType.ERROR, "Form Error!",
                    "Please enter your email");
            emailTextField.requestFocus();
            return;
        }

        User user = new User(firstNameTextField.getText(), lastNameTextField.getText(), emailTextField.getText());
        showAlert(AlertType.INFORMATION, "Registration Successful!",
                String.format("Welcome %s %nUser object created: %s", 
                		firstNameTextField.getText(), user) );
    }
    
    @FXML
    public void initialize() {
    	//Allow selection of multiple degree
    	degreesList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    	//ToDo: initialize combo boxes and lists
    }
    
    private void showAlert(AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.show();
    }    
}
