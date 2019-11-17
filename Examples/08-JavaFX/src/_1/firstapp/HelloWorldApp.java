package _1.firstapp;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class HelloWorldApp extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Label label = new Label("Hello World");
        label.setAlignment(Pos.CENTER);
         
        //Create a Scene by passing the label object, height and width   
        Scene scene = new Scene(label ,600, 300); 

        //Add the scene to Stage 
        stage.setScene(scene);
        
        //Set the title of the Stage. 
        stage.setTitle("Hello World App");
  
        //Display the stage 
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
