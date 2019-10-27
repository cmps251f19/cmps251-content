package _7.Properties;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionModel;
import javafx.scene.control.Separator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Table extends Application {

	@Override
	public void start(Stage stage) {
		final VBox root = new VBox();
		final HBox toolBar = new HBox();

		final TextField nameTextField = new TextField();
		final Button addNameBtn = new Button("Add Names");
		final Button deleteBtn = new Button("Delete Name");
		
		final ObservableList<Person> persons = FXCollections.observableArrayList(
				new Person("Ali", "Saleh", "saleh@example.com"),
				new Person("Samir", "Saghir", "samir@example.com"),
				new Person("Fatima", "Al-Marri", "fatima@example.com"),
				new Person("Samira", "Abbes", "samira@example.com")
		);
		
		final TableView<Person> table = new TableView<>(persons);
		final TableColumn<Person, String> firstNameCol = new TableColumn<>("First Name");
		final TableColumn<Person, String> lastNameCol = new TableColumn<>("Last Name");
		final TableColumn<Person, String> emailCol = new TableColumn<>("Email");

		table.getColumns().addAll(firstNameCol, lastNameCol, emailCol);
		
		firstNameCol.setCellValueFactory(
				new PropertyValueFactory<Person, String>("firstName"));
		lastNameCol.setCellValueFactory(
				new PropertyValueFactory<Person, String>("lastName"));
		emailCol.setCellValueFactory(
				new PropertyValueFactory<Person, String>("email"));
		
		table.setEditable(true);
		firstNameCol.setCellFactory(TextFieldTableCell.<Person>forTableColumn());
		
		firstNameCol.setOnEditCommit((CellEditEvent<Person, String> event) -> {
			final Person person = event.getRowValue();
			person.setFirstName(event.getNewValue());
		});
		
		lastNameCol.setCellFactory(TextFieldTableCell.<Person>forTableColumn());
		lastNameCol.setOnEditCommit(event -> {
			final Person person = event.getRowValue();
			person.setLastName(event.getNewValue());
		});
		
		/*birthdayCol.setCellFactory(col -> new LocalDateCell());
		birthdayCol.setOnEditCommit(event -> {
			Person localDate = event.getRowValue();
			localDate.setBirthday(event.getNewValue());
		});*/
		
		addNameBtn.setOnAction(event -> {
			/*String name = nameTextField.getText();
			if (!name.isEmpty() && !entries.contains(name)) {
				entries.add(name);
				nameTextField.clear();
			}*/
		});
		
		deleteBtn.setOnAction(event -> {
			//final int selectedIdx = listView.getSelectionModel().getSelectedIndex();
			//entries.remove(selectedIdx);
		});

		toolBar.getChildren().addAll(nameTextField, addNameBtn, new Separator(Orientation.VERTICAL), deleteBtn);
		toolBar.setSpacing(10);
		root.getChildren().addAll(toolBar, table);
		root.setSpacing(10);
		root.setAlignment(Pos.TOP_CENTER);
		
		Scene scene = new Scene(root, 350, 350);
		stage.setScene(scene);
		stage.setTitle("Binding a List to ListView");
		stage.show();
	}

	public static void main(String args[]) {
		launch(args);
	}
}
