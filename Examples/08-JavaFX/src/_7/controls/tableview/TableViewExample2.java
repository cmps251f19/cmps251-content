package _7.controls.tableview;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
 
public class TableViewExample2 extends Application {
	private ObservableList<Student> studentsList = null;
	
    private void initStudentsList() {
    	studentsList = FXCollections.observableArrayList();
        studentsList.add(new Student(12, "Ali", "Faleh", "ali@example.com"));
        studentsList.add(new Student(15, "Khadija", "Saleh", "khadija@example.com"));
        studentsList.add(new Student(100, "Mariam", "Salem", "mariam@example.com"));
    }
 
    public static void main(String[] args) {
        launch(args);
    }

    private void handleStudentSelected(Student student) {
    	System.out.println(student);
        // check the table's selected item and get selected item
        /*if (table.getSelectionModel().getSelectedItem() != null) {
            Person selectedPerson = table.getSelectionModel().getSelectedItem();
            nameTextField.setText(selectedPerson.getName());
            addressTextField.setText(selectedPerson.getAddress());
        }*/
    }
    
    @Override
    public void start(Stage stage) {
    	initStudentsList();
        TableView<Student> tableView = new TableView<>();
        
        tableView.addEventHandler(MouseEvent.MOUSE_CLICKED, (e) -> {
            if(e.getClickCount() == 2) {
                System.out.println("Double clicked");
                if (tableView.getSelectionModel().getSelectedItem() != null) {
                	Student student = tableView.getSelectionModel().getSelectedItem();
                	handleStudentSelected(student);
                }
            }
        });
        
        tableView.getSelectionModel().selectedItemProperty().addListener((selectedRow, oldSelection, newSelection) -> {
            if (newSelection != null) {
            	//handleStudentSelected(newSelection);
            }
        });
        /*tableView.setOnMouseClicked((MouseEvent event) -> {
            if (event.getClickCount() > 1) {
                onEdit();
            }
        });*/

        TableColumn<Student, Integer> colId = new TableColumn<>("Id");
        colId.setCellValueFactory(new PropertyValueFactory("id"));
        
        TableColumn<Student, String> colFirstName = new TableColumn<>("First Name");
        colFirstName.setCellValueFactory(new PropertyValueFactory("firstName"));

        TableColumn<Student, String> colLastName = new TableColumn<>("Last Name");
        colLastName.setCellValueFactory(new PropertyValueFactory("lastName"));

        TableColumn<Student, String> colEmail = new TableColumn("Email");
        colEmail.setCellValueFactory(new PropertyValueFactory("email"));
        
        final Button deleteBtn = new Button("Delete");
		deleteBtn.disableProperty().bind(Bindings.isNull(
				tableView.getSelectionModel().selectedItemProperty()));
		
		deleteBtn.setOnAction(event -> {
			int selectedIdx = tableView.getSelectionModel().getSelectedIndex();
			studentsList.remove(selectedIdx);
		});
		
        tableView.getColumns().addAll(colId, colFirstName, colLastName, colEmail);
        tableView.setItems(studentsList);
		
        VBox root = new VBox(deleteBtn, tableView);
        root.setSpacing(10);
        
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("TableView Example");
        stage.show();
    }
}


//Add Column Buttons - give-up as it is bit complex
/*
TableColumn<Student, String> colAction = new TableColumn<>("Action");
colAction.setCellValueFactory(new PropertyValueFactory<>("email"));

colAction.setCellFactory(param -> new TableCell<Student, String>() {
    private final Button editButton = new Button("edit");
    private final Button deleteButton = new Button("delete");

    @Override
    protected void updateItem(String email, boolean empty) {
    	System.out.println(email);
        super.updateItem(email, empty);

        if (email == null) {
            setGraphic(null);
            return;
        }

        deleteButton.setOnAction(event -> {
        	System.out.println(event.getSource());
            Student s = tableView.getSelectionModel().getSelectedItem();
            if (s != null)
            	System.out.println(s.getFirstName() + "   " + s.getLastName());
        });

        editButton.setOnAction(event -> {
            Student s = tableView.getSelectionModel().getSelectedItem();
            if (s != null)
            	System.out.println(s.getFirstName() + "   " + s.getLastName());
        });

        HBox pane = new HBox(editButton, deleteButton);
        setGraphic(pane);
    }
}); */