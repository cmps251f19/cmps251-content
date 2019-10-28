package _w15.apps;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

public class VideoPlayerExample extends Application {
    @Override
    public void start(Stage stage) throws Exception {
    	VBox root = new VBox();
		root.setSpacing(10);
		root.setAlignment(Pos.CENTER);
		
		Media media = new Media("http://www.w3schools.com/html/movie.mp4");
    	MediaPlayer player = new MediaPlayer(media);
    	MediaView mediaView = new MediaView(player);
    	root.getChildren().add(mediaView);
         
        //Create a Scene by passing the label object, height and width   
        Scene scene = new Scene(root ,600, 300); 

        //Add the scene to Stage 
        stage.setScene(scene);
        
        //Set the title of the Stage. 
        stage.setTitle("Video Player");
  
        //Display the stage 
        stage.show();
        player.play();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
