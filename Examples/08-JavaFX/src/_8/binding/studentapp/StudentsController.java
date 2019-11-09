package _8.binding.studentapp;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;

enum DialogMode {ADD, UPDATE}

public class StudentsController {
    @FXML
    private Button addButton;
    
    @FXML
    private Button deleteButton;

    @FXML
    private Button updateButton;
    
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

	private ObservableList<Student> studentsOL = null;
	
    @FXML
    void handleDelete(ActionEvent event) {
    	
		Optional<ButtonType> isConfirmed = showConfirmationDialog("Confim Delete", 
				"Delete Confirmation", "Are you sure you would like to delete the selected student?");
		if (isConfirmed.get() == ButtonType.OK) {
			int selectedIdx = studentsTable.getSelectionModel().getSelectedIndex();
			studentsOL.remove(selectedIdx);
		}
    }
    
    @FXML
    void handleAdd(ActionEvent event) {
    	handleUpdate(event);
    }
    
    @FXML
    void handleUpdate(ActionEvent event) {
    	Student student = null;
    	String dialogTitle = "";
    	DialogMode mode;
    	
    	if (event.getSource().equals(updateButton)) {
    		mode = DialogMode.UPDATE;
    		dialogTitle = "Update Student";
    		student = studentsTable.getSelectionModel().getSelectedItem();
    	} else if (event.getSource().equals(addButton)) {
    		mode = DialogMode.ADD;
    		dialogTitle = "Add Student";
    		student = new Student();
    	} else {
    		return;
    	}

        try {
            // Load the fxml file and create a new popup dialog.
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("StudentEditor.fxml"));
            DialogPane studentDialogPane = fxmlLoader.load();
            
            //Get the student controller associated with the view            
            StudentController studentController = fxmlLoader.getController();
            //Pass the new student / student to the update the controller associated
            //with the studentDialogPane
            studentController.setStudent(student);
            
    		Dialog<ButtonType> dialog = new Dialog<>();
    		dialog.setDialogPane(studentDialogPane);
    		dialog.setTitle(dialogTitle);
            
    		Optional<ButtonType> clickedButton = dialog.showAndWait();
    		//ToDo: push the changes to the model then to a file
    		if (clickedButton.get() == ButtonType.OK){
    			System.out.println("User selected ok"); 
    			if (mode == DialogMode.ADD) {
    				studentsOL.add(student);
    			}
    		}
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    void handleSave(ActionEvent event) {
    	StudentRepository.saveStudents(studentsOL.toArray(new Student[studentsOL.size()]));
    	showInformationDialog("Confirmation", "", "Students saved successfuly.");
    }

    //Auto called when the view is created
    public void initialize() {
		//Initialize the list of students and pass it to studentsTable to display it
		//Must convert a list to an ObservableList to be able to use it with the TableView component
    	List<Student> students = StudentRepository.getStudents();
		studentsOL = FXCollections.observableArrayList( students );
    	studentsTable.setItems(studentsOL);
    	
    	//Link table columns to student attributes
    	/*A TableColumn must have a cell value factory to extracts from 
    	the object the value to be displayed in each cell (on each row) in the column. */
    	idCol.setCellValueFactory(new PropertyValueFactory("id"));
        firstNameCol.setCellValueFactory(new PropertyValueFactory("firstName"));
        lastNameCol.setCellValueFactory(new PropertyValueFactory("lastName"));
        emailCol.setCellValueFactory(new PropertyValueFactory("email"));
        
        //If no student selected then disable to delete button
		deleteButton.disableProperty().bind( Bindings.isNull(
				studentsTable.getSelectionModel().selectedItemProperty()) );
		
		updateButton.disableProperty().bind( Bindings.isNull(
				studentsTable.getSelectionModel().selectedItemProperty()) );
		
		//Bind message label to the index of the selected table row
		messageLabel.textProperty().bind(
				studentsTable.getSelectionModel().selectedIndexProperty().asString());
    }
    
	private Optional<ButtonType> showConfirmationDialog(String title, String headerText, String contentText) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle(title);
		alert.setHeaderText(headerText);
		alert.setContentText(contentText);

		return alert.showAndWait();
	}
	
	private void showInformationDialog(String title, String headerText, String contentText)
	{
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle(title);
		alert.setHeaderText(headerText);
		alert.setContentText(contentText);
		alert.showAndWait();
	}
}