package _9.mvapp.member;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
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
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;

enum DialogMode {ADD, UPDATE}

public class MembersController {
    @FXML
    private MenuItem addStudentMenuItem;

    @FXML
    private MenuItem addFacultyMenuItem;
    
    @FXML
    private Button deleteButton;

    @FXML
    private Button updateButton;
    
    @FXML
    private TableView<Member> membersTable;

    @FXML
    private TableColumn<Member, Integer> idCol;

    @FXML
    private TableColumn<Member, String> firstNameCol;

    @FXML
    private TableColumn<Member, String> lastNameCol;

    @FXML
    private TableColumn<Member, String> emailCol;
    
    @FXML
    private TableColumn<Member, String> gpaCol;
    
    @FXML
    private TableColumn<Member, String> officeCol;

    @FXML
    private Label messageLabel;

	private ObservableList<Member> membersOL = null;
	
    @FXML
    void handleDelete(ActionEvent event) {
    	
		Optional<ButtonType> isConfirmed = showConfirmationDialog("Confim Delete", 
				"Delete Confirmation", "Are you sure you would like to delete the selected member?");
		if (isConfirmed.get() == ButtonType.OK) {
			int selectedIdx = membersTable.getSelectionModel().getSelectedIndex();
			membersOL.remove(selectedIdx);
		}
    }
    
    @FXML
    void handleAdd(ActionEvent event) {
    	handleUpdate(event);
    }
    
    @FXML
    void handleUpdate(ActionEvent event) {
    	Member member = null;
    	String dialogTitle = "";
    	DialogMode mode;
    	
    	if (event.getSource().equals(updateButton)) {
    		mode = DialogMode.UPDATE;
    		member = membersTable.getSelectionModel().getSelectedItem();
    		dialogTitle = String.format("Update %s", member.getClass().getSimpleName() );
    	} else if (event.getSource().equals(addStudentMenuItem)) {
    		mode = DialogMode.ADD;
    		dialogTitle = "Add Student";
    		member = new Student();
    	} else if (event.getSource().equals(addFacultyMenuItem)) {
    		mode = DialogMode.ADD;
    		dialogTitle = "Add Faculty";
    		member = new Faculty();
    	} else {
    		return;
    	}

        try {
            // Load the fxml file and create a new popup dialog.
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("MemberEditor.fxml"));
            DialogPane memberDialogPane = fxmlLoader.load();
            
            //Get the member controller associated with the view            
            MemberController memberController = fxmlLoader.getController();
            //Pass the new member / member to the update the controller associated
            //with the memberDialogPane
            memberController.setMember(member);
            
    		Dialog<ButtonType> dialog = new Dialog<>();
    		dialog.setDialogPane(memberDialogPane);
    		dialog.setTitle(dialogTitle);
            
    		Optional<ButtonType> clickedButton = dialog.showAndWait();
    		//ToDo: push the changes to the model then to a file
    		if (clickedButton.get() == ButtonType.OK){
    			System.out.println("User selected ok"); 
    			if (mode == DialogMode.ADD) {
    				membersOL.add(member);
    			}
    		}
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    void handleSave(ActionEvent event) {
    	MemberRepository.saveMembers(membersOL.toArray(new Member[membersOL.size()]));
    	showInformationDialog("Confirmation", "", "Students saved successfuly.");
    }

    //Auto called when the view is created
    public void initialize() {
		//Initialize the list of members and pass it to membersTable to display it
		//Must convert a list to an ObservableList to be able to use it with the TableView component
    	List<Member> members = MemberRepository.getMembers();
		membersOL = FXCollections.observableArrayList( members );
    	membersTable.setItems(membersOL);
    	
    	//Link table columns to member attributes
    	/*A TableColumn must have a cell value factory to extracts from 
    	the object the value to be displayed in each cell (on each row) in the column. */
    	idCol.setCellValueFactory(new PropertyValueFactory("id"));
        firstNameCol.setCellValueFactory(new PropertyValueFactory("firstName"));
        lastNameCol.setCellValueFactory(new PropertyValueFactory("lastName"));
        emailCol.setCellValueFactory(new PropertyValueFactory("email"));
        //gpaCol.setCellValueFactory(new PropertyValueFactory("gpa"));
        gpaCol.setCellValueFactory(cellData -> {
        	Member member = cellData.getValue();
        	if (member instanceof Student)
        		return ((Student)member).gpaProperty().asString();
        	else
        		return new SimpleStringProperty();
        });
        //officeCol.setCellValueFactory(new PropertyValueFactory("office"));
        officeCol.setCellValueFactory(cellData -> {
        	Member member = cellData.getValue();
        	//System.out.println(member);
        	if (member instanceof Faculty)
        		return ((Faculty)member).officeProperty();
        	else
        		return new SimpleStringProperty();
        });
        
        //If no member selected then disable to delete button
		deleteButton.disableProperty().bind( Bindings.isNull(
				membersTable.getSelectionModel().selectedItemProperty()) );
		
		updateButton.disableProperty().bind( Bindings.isNull(
				membersTable.getSelectionModel().selectedItemProperty()) );
		
		//Bind message label to the index of the selected table row
		messageLabel.textProperty().bind(
				membersTable.getSelectionModel().selectedIndexProperty().asString());
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