package _8.binding.firstexample;

import java.text.NumberFormat;

import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class FriendController {
	Friend myFriend;
	
    @FXML
    private TextField nameField;

    @FXML
    private TextField ageField;
    
    @FXML
    private Label messageLabel;

    @FXML
    void handleSubmit(ActionEvent event) {
    	//myFriend.setName(nameField.getText());
    	//myFriend.setAge( Integer.valueOf(ageField.getText()) );
    	System.out.println(myFriend);
    }
    
    public void initialize() {
		myFriend = new Friend("Ahmed", 30);
		System.out.println(myFriend);
		
		nameField.textProperty().bindBidirectional(myFriend.nameProperty());
		ageField.textProperty().bindBidirectional(myFriend.ageProperty(), NumberFormat.getNumberInstance());
		messageLabel.textProperty().bind(
				Bindings.concat(myFriend.nameProperty(), " - ", myFriend.ageProperty()) );
		//nameField.setText(myFriend.getName());
		//ageField.setText( String.valueOf(myFriend.getAge()) ); 
    }

}
