package _6.controls.tableview;

import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class TableViewController {

    @FXML
    private Button deleteButton;

    @FXML
    private TableView<Student> studentsTable;

    @FXML
    private TableColumn<Student, Integer> idCol;

    @FXML
    private TableColumn<Student, String> firstNameCol;

    @FXML
    private TableColumn<Student, String> lastNameCol;

    @FXML
    private TableColumn<Student, String> emailCol;

    @FXML
    private Label messageLabel;

	private ObservableList<Student> students = null;
	
    @FXML
    void handleDelete(ActionEvent event) {
		int selectedIdx = studentsTable.getSelectionModel().getSelectedIndex();
		students.remove(selectedIdx);
    }
    
    //Auto called when the view is created
    public void initialize() {
		//Initialize the list of students and pass it to studentsTable to display it
		//Must convert a list to an ObservableList to be able to use it with the TableView component
		students = FXCollections.observableArrayList(StudentRepository.getStudents());
    	studentsTable.setItems(students);
    	
    	//Link table columns to student attributes
    	/*A TableColumn must have a cell value factory to extracts from 
    	the object the value to be displayed in each cell (on each row) in the column. */
        idCol.setCellValueFactory(new PropertyValueFactory("id"));
        firstNameCol.setCellValueFactory(new PropertyValueFactory("firstName"));
        lastNameCol.setCellValueFactory(new PropertyValueFactory("lastName"));
        emailCol.setCellValueFactory(new PropertyValueFactory("email"));
        
        //If no student selected then disable to delete button
		deleteButton.disableProperty().bind(Bindings.isNull(
				studentsTable.getSelectionModel().selectedItemProperty()));
		
		//Bind message label to the index of the selected table row
		messageLabel.textProperty().bind(
				studentsTable.getSelectionModel().selectedIndexProperty().asString());

    }
}