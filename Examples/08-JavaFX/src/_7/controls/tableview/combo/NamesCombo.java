package _7.controls.tableview.combo;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionModel;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class NamesCombo extends Application {

	@Override
	public void start(Stage stage) {
		HBox root = new HBox();
		final String[] names = { "Ali", "Ahmed", "Fatima", "Sara", "Samira" };
		final ObservableList<String> entries = FXCollections.observableArrayList(names);
		final ComboBox<String> namesCombo = new ComboBox<>(entries);
		final Button addNameBtn = new Button("Add Names");
		
		addNameBtn.setOnAction(event -> {
			entries.addAll("Abbas", "Farid");
			namesCombo.show();
		});

		root.getChildren().addAll(namesCombo, addNameBtn);
		root.setSpacing(10);
		root.setAlignment(Pos.TOP_CENTER);
		
		Scene scene = new Scene(root, 350, 100);
		stage.setScene(scene);
		stage.setTitle("Binding a List to Combobox");
		stage.show();
	}

	public static void main(String args[]) {
		launch(args);
	}
}
