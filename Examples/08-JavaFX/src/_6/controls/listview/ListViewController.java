package _6.controls.listview;

import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;

public class ListViewController {
    @FXML
    private TextField collegeTextField;

    @FXML
    private Button addButton;

    @FXML
    private Button deleteButton;

    @FXML
    private ListView<String> collegesListView;

    @FXML
    private Label messageLabel;

	private ObservableList<String> collegesOL = null;

    @FXML
    void handleAdd(ActionEvent event) {
		String college = collegeTextField.getText();
		if (!college.isEmpty() && !collegesOL.contains(college)) {
			collegesOL.add(college);
			collegeTextField.clear();
		}
    }
    
    @FXML
    void handleDelete(ActionEvent event) {
		int selectedIdx = collegesListView.getSelectionModel().getSelectedIndex();
		collegesOL.remove(selectedIdx);
    }
    
    //Auto called when the view is created
    public void initialize() {
    	collegesListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		//Initialize the list of students and pass it to collegesList to display it
		//Must convert a list to an ObservableList to be able to use it with the TableView component
		collegesOL = FXCollections.observableArrayList(CollegeRespository.getColleges());
    	collegesListView.setItems(collegesOL);
    	
    	//You can listen to the ObservableList changes
    	collegesOL.addListener( (ListChangeListener.Change<? extends String> change) -> {
    		System.out.println(change);
    	});
    	
    	//If no college selected then disable the delete button
		deleteButton.disableProperty().bind(Bindings.isNull(
				collegesListView.getSelectionModel().selectedItemProperty()));
		
		//Bind message label to the index of the selected table row
		messageLabel.textProperty().bind(
				collegesListView.getSelectionModel().selectedIndexProperty().asString());
		
        //If the collegeTextField is empty then disable the add button
		addButton.disableProperty().bind( Bindings.isEmpty(
				collegeTextField.textProperty()) );
    }
}