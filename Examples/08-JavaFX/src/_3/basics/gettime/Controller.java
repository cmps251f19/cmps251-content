package _3.basics.gettime;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Controller {
    @FXML private Label timeLabel;

    @FXML void handleGetTime(ActionEvent event) {
    	timeLabel.setText( Model.getCurrentDateTime() );
    }
}
