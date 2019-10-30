package _6.controls.listview;

import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class ListViewController {
    @FXML
    private TextField collegeTextField;

    @FXML
    private Button addButton;

    @FXML
    private Button deleteButton;

    @FXML
    private ListView<String> collegesList;

    @FXML
    private Label messageLabel;

	private ObservableList<String> colleges = null;

    @FXML
    void handleAdd(ActionEvent event) {
		String college = collegeTextField.getText();
		if (!college.isEmpty() && !colleges.contains(college)) {
			colleges.add(college);
			collegeTextField.clear();
		}
    }
    
    @FXML
    void handleDelete(ActionEvent event) {
		int selectedIdx = collegesList.getSelectionModel().getSelectedIndex();
		colleges.remove(selectedIdx);
    }
    
    //Auto called when the view is created
    public void initialize() {
		//Initialize the list of students and pass it to collegesList to display it
		//Must convert a list to an ObservableList to be able to use it with the TableView component
		colleges = FXCollections.observableArrayList(CollegeRespository.getColleges());
    	collegesList.setItems(colleges);
    	
        //If no student selected then disable to delete button
		deleteButton.disableProperty().bind(Bindings.isNull(
				collegesList.getSelectionModel().selectedItemProperty()));
		
		//Bind message label to the index of the selected table row
		messageLabel.textProperty().bind(
				collegesList.getSelectionModel().selectedIndexProperty().asString());
		
        //If no collegeTextField is empty then disable to add button
		addButton.disableProperty().bind( Bindings.isEmpty(
				collegeTextField.textProperty()) );
    }
}