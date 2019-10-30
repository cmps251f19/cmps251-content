package _6.controls.combobox;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

public class ComboBoxController {

    @FXML
    private ComboBox<String> collegesCombo;
    
    @FXML
    private Label messageLabel;
   
    @FXML
    void handleCollegeSelected(ActionEvent event) {
    	String selectedCollege = collegesCombo.getSelectionModel().getSelectedItem();
    	messageLabel.setText(String.format("Selected college: %s", selectedCollege));
    }
    
    //Auto called when the view is created
    public void initialize() {
		final ObservableList<String> colleges = FXCollections.observableArrayList(CollegeRespository.getColleges());
		collegesCombo.setItems(colleges);
    }

}