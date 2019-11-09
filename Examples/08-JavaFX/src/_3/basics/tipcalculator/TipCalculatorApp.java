package _3.basics.tipcalculator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class TipCalculatorApp extends Application {
   @Override
   public void start(Stage stage) throws Exception {
      Pane root = FXMLLoader.load(getClass().getResource("TipCalculator.fxml"));

      Scene scene = new Scene(root); // attach scene graph to scene
      stage.setTitle("Tip Calculator"); // displayed in window's title bar
      stage.setScene(scene); // attach scene to stage
      stage.show(); // display the stage
   }

   public static void main(String[] args) {
      launch(args); 
   }
}