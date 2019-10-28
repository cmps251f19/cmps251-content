package _1.firstapp;

import java.util.Arrays;
import java.util.Random;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ColorChanger extends Application {

    @Override
    public void start(Stage stage) {
    	VBox root = new VBox();
		Label label = new Label("JavaFX Rocks!");
		Button button = new Button("Random Color");
		button.setTextFill(Color.BLUE);
		root.getChildren().addAll(label, button);
		root.setSpacing(10);
		root.setAlignment(Pos.CENTER);
		
		//Handle the click event or you can use button.setOnMouseClicked
		button.setOnAction(event -> {
			int min = 0, max = 255, count = 3;
			int[] randomInts = getRandomIntInRange(min, max, count);
			System.out.println(Arrays.toString(randomInts));
			int red = randomInts[0];
		   	int green = randomInts[1];
			int blue = randomInts[2];
			//Generate a color
			//e.g.: Color.WHITE can be expressed as Color.rgb(255,255,255)
		    Color color = Color.rgb(red, green, blue);
			label.setTextFill(color);
		});

        Scene scene = new Scene(root, 200, 200);
        stage.setScene(scene);
        stage.setTitle("Color Changer");
        stage.show();
    }
    
	public  static void main(String args[]) {
		launch(args);
	}
	
	//Generates a random integer from min (inclusive) to max (exclusive)
	private static int[] getRandomIntInRange(int min, int max, int count) {
		Random random = new Random();
		return random.ints(min, (max + 1)).limit(count).toArray();
	}
}