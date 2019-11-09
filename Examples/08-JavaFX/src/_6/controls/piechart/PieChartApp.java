package _6.controls.piechart;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class PieChartApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Pane root = FXMLLoader.load(getClass().getResource("PieChart.fxml"));
        stage.setScene(new Scene(root, 500, 400));
        stage.setTitle("PieChart App");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}