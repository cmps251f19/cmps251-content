package _7.controls.tableview.combo;

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
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class EditableListView extends Application {

	@Override
	public void start(Stage stage) {
		final VBox root = new VBox();
		final HBox toolBar = new HBox();

		final TextField nameTextField = new TextField();
		final Button addNameBtn = new Button("Add Names");
		final Button deleteBtn = new Button("Delete Name");
		
		final String[] names = { "Ali", "Ahmed", "Fatima", "Sara", "Samira" };
		final ObservableList<String> entries = FXCollections.observableArrayList(names);
		final ListView<String> listView = new ListView<>(entries);
		
		deleteBtn.disableProperty().bind(Bindings.isNull(
				listView.getSelectionModel().selectedItemProperty()));
		
		addNameBtn.setOnAction(event -> {
			String name = nameTextField.getText();
			if (!name.isEmpty() && !entries.contains(name)) {
				entries.add(name);
				nameTextField.clear();
			}
		});
		
		deleteBtn.setOnAction(event -> {
			int selectedIdx = listView.getSelectionModel().getSelectedIndex();
			entries.remove(selectedIdx);
		});

		toolBar.getChildren().addAll(nameTextField, addNameBtn, new Separator(Orientation.VERTICAL), deleteBtn);
		toolBar.setSpacing(10);
		root.getChildren().addAll(toolBar, listView);
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
