package _6.dialogs;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ErrorDialog extends Application {
	@Override
	public void start(Stage stage) throws Exception
	{
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Error Dialog");
		alert.setHeaderText("Header-Text for Error Dialog");
		alert.setContentText("Content-Text. Attention!\n" +
			"There was an error opening the students.json file\n" +
			"Make sure the file exists and try again");
		alert.showAndWait();
	}
	
	public static void main(String args[]) {
		launch(args);
	}
}
