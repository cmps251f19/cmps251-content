package _7.Properties;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PieCharts extends Application {

	@Override
	public void start(Stage stage) throws Exception
	{
		PieChart pieChart = new PieChart();
		pieChart.setData(createChartData());
		VBox root = new VBox();
		root.getChildren().add(pieChart);
		stage.setScene(new Scene(root));
		stage.setTitle("Pie Chart Example");
		stage.show();
	}
	private ObservableList<Data> createChartData() {
		ObservableList<Data> data =FXCollections.observableArrayList();
		data.add(new Data("Java", 70.5));
		data.add(new Data("C#", 20.5));
		data.add(new Data("Python", 9));
		return data;
	}

	public static void main(String args[]) {
		launch(args);
	}
}
