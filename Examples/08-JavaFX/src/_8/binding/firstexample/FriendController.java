package _8.binding.firstexample;

import java.text.NumberFormat;

import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class FriendController {
	Friend friend = new Friend("Sara", 18);
	@FXML private TextField nameField;
    @FXML private TextField ageField;
    @FXML private Label messageLabel;

    @FXML void handleSubmit(ActionEvent event) {
    	//Write UI values of object attributes
    	friend.setName(nameField.getText());
    	friend.setAge( Integer.valueOf(ageField.getText()) );
    	//Show concatenated object attributes in a label
    	messageLabel.setText( friend.getName() + " - " + friend.getAge() );
    	System.out.println(friend);
    }
    
    public void initialize() {
		//Write values of object attributes to UI
		nameField.setText(friend.getName());
		ageField.setText( String.valueOf(friend.getAge()) ); 
		messageLabel.setText( friend.getName() + " - " + friend.getAge() );
		
		/*
		nameField.textProperty().bindBidirectional(friend.nameProperty());
		ageField.textProperty().bindBidirectional(friend.ageProperty(), NumberFormat.getNumberInstance());
		messageLabel.textProperty().bind(
				Bindings.concat(friend.nameProperty(), " - ", friend.ageProperty()) );
		*/
    }
}
