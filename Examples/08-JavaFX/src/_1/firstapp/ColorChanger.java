package _1.firstapp;

import java.util.Random;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ColorChanger extends Application {

    @Override
    public void start(Stage stage) {
    	VBox root = new VBox();
		Label label = new Label("JavaFX Rocks!");
		Button button = new Button("Random Color");
		root.getChildren().addAll(label, button);
		root.setSpacing(8);
		root.setAlignment(Pos.TOP_CENTER);
		
		//Handle the click event
		button.setOnMouseClicked(event -> {
			int min = 0, max = 255;
			int red = getRandomIntInRange(min, max);
		   	int green = getRandomIntInRange(min, max); 
			int blue = getRandomIntInRange(min, max);
			//Generate a color
			//e.g.: Color.WHITE can be expressed as Color.rgb(255,255,255)
		    Color color = Color.rgb(red, green, blue);
			label.setTextFill(color);
		});

        Scene scene = new Scene(root,80,80);
        stage.setScene(scene);
        stage.setTitle("Color Changer");
        stage.show();
    }
    
	public  static void main(String args[]) {
		launch(args);
	}
	
	//Generates a random integer from min (inclusive) to max (exclusive)
	private static int getRandomIntInRange(int min, int max) {
		Random r = new Random();
		return r.ints(min, (max + 1)).findFirst().getAsInt();
	}
}