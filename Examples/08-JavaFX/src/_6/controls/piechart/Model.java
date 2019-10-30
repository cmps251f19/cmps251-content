package _6.controls.piechart;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart.Data;

public class Model {
	public static ObservableList<Data> getChartData() {
		ObservableList<Data> data =FXCollections.observableArrayList();
		data.add(new Data("Java", 70.5));
		data.add(new Data("C#", 20.5));
		data.add(new Data("Python", 9));
		return data;
	}
}
