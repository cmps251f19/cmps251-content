package _6.controls.piechart;

import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;

public class PieChartController {

    @FXML
    private PieChart pieChart;
    
    //Auto called when the view is created
    public void initialize() {
    	pieChart.setData(Model.getChartData());
    }

}