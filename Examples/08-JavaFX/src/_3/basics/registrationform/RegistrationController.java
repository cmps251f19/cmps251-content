package _3.basics.registrationform;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class RegistrationController {
    @FXML
    private TextField nameTextField;

    @FXML
    private TextField emailTextField;

    @FXML
    private PasswordField passwordField;

    @FXML
    protected void handleSubmit(ActionEvent event) {
        if(nameTextField.getText().isEmpty()) {
            showAlert(AlertType.ERROR, "Form Error!",
                    "Please enter your name");
            return;
        }
        
        if(emailTextField.getText().isEmpty()) {
            showAlert(AlertType.ERROR, "Form Error!",
                    "Please enter your email id");
            return;
        }
        if(passwordField.getText().isEmpty()) {
            showAlert(AlertType.ERROR, "Form Error!",
                    "Please enter a password");
            return;
        }

        User user = new User(nameTextField.getText(), emailTextField.getText(), passwordField.getText());
        showAlert(AlertType.INFORMATION, "Registration Successful!",
                String.format("Welcome %s %nUser object created: %s", 
                		nameTextField.getText(), user) );
    }
    
    private void showAlert(AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.show();
    }
}
