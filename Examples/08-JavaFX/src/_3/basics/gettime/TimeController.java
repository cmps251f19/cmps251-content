package _3.basics.gettime;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class TimeController {
    @FXML private Label timeLabel;

    @FXML void handleGetTime(ActionEvent event) {
    	timeLabel.setText( TimeModel.getCurrentDateTime() );
    }
    
    //Auto called when the view is created
    public void initialize() {
    	handleGetTime(null);
    }
}
