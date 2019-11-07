package _6.controls.tableview;

import java.text.NumberFormat;

import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class StudentController {
	private Student student;
	
    @FXML
    private TextField idField;

    @FXML
    private TextField firstNameField;

    @FXML
    private TextField lastNameField;

    @FXML
    private TextField emailField;
    
    //Called by the Main controller to pass a student object to dialog box
    public void setStudent(Student student) {
    	this.student = student;
    	
    	//Bind the student properties to the UI controls 
    	idField.textProperty().bindBidirectional(student.idProperty(), 
    			NumberFormat.getNumberInstance());
    	firstNameField.textProperty().bindBidirectional(student.firstNameProperty());
    	lastNameField.textProperty().bindBidirectional(student.lastNameProperty());
    	emailField.textProperty().bindBidirectional(student.emailProperty());
    	
    }
}