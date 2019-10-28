package _7.controls.tableview;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class TableViewController implements Initializable {
    
    @FXML
    private Label label;
    
    @FXML 
     TableView tableview;    
    
    ObservableList<Person> data;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        TableColumn firstNameCol = new TableColumn("First Name");
        TableColumn lastNameCol = new TableColumn("Last Name");
        TableColumn emailCol = new TableColumn("Email"); 
        TableColumn actionCol = new TableColumn("Remarks"); 
                
       
    tableview.getColumns().addAll(firstNameCol, lastNameCol, emailCol, actionCol );
        
    data = FXCollections.observableArrayList(
    new Person("Jacob", "Smith", "jacob.smith@example.com", ""),
    new Person("Isabella", "Johnson", "isabella.johnson@example.com", ""),
    new Person("Ethan", "Williams", "ethan.williams@example.com", ""),
    new Person("Emma", "Jones", "emma.jones@example.com", ""),
    new Person("Michael", "Brown", "michael.brown@example.com", ""),
    new Person("Michael", "Brown", "michael.brown@example.com", ""),
    new Person("Michael", "Brown", "michael.brown@example.com", ""),
    new Person("Michael", "Brown", "michael.brown@example.com", "")
    );
    
    firstNameCol.setCellValueFactory(
    		new PropertyValueFactory<Person,String>("firstName")
    );
    lastNameCol.setCellValueFactory(
    		new PropertyValueFactory<Person,String>("lastName")
    );
     emailCol.setCellValueFactory(     
             new PropertyValueFactory<Person,String>("email")
    );             
    
    actionCol.setCellValueFactory(     
             new PropertyValueFactory<Person,String>("remark")
    );         
     
    tableview.setItems(data);                         
    }  
}