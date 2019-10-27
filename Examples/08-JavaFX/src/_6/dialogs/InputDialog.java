package _6.dialogs;

import java.util.Optional;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class InputDialog extends Application {
	@Override
	public void start(Stage stage) throws Exception
	{
		TextInputDialog dialog = new TextInputDialog();
		dialog.setTitle("Name input dialog");
		dialog.setHeaderText("Enter your name");		
		Optional<String> result = dialog.showAndWait();
		result.ifPresent(name -> System.out.println("Your name: " + name));
	}
	
	public static void main(String args[]) {
		launch(args);
	}
}
