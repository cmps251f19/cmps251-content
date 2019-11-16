package _6.controls.combobox;

import java.util.List;

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
    @FXML
    public void initialize() {
    	List<String> collegesList = CollegeRespository.getColleges();
		ObservableList<String> colleges = FXCollections.observableArrayList(collegesList);
		collegesCombo.setItems(colleges);
    }

}