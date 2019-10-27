package _5.calculator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CalculatorFX extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("calculator.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.setTitle("Calculator");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
