package _1.firstapp;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class YaHalaWord extends Application {
     
    @Override
    public void start(Stage stage) {
         
        //Create Label, then add graphic to it
        Label imageLabel = new Label("Ya Hala");
        imageLabel.setGraphic(new ImageView(new Image("https://upload.wikimedia.org/wikipedia/commons/3/30/QU_logo.jpg")));
        imageLabel.setFont(Font.font("Arial Black", 24));
        imageLabel.setTextFill(Color.SANDYBROWN);
        
        StackPane root = new StackPane();
        root.getChildren().add(imageLabel);
         
        Scene scene = new Scene(root, 400, 350);
         
        stage.setTitle("Ya Hala @ QU");
        //set icon of the application
        Image appIcon = new Image(getClass().getResourceAsStream("hand-shake.png"));
        stage.getIcons().add(appIcon);
        
        stage.setScene(scene);
        stage.show();
    }
 
    public static void main(String[] args) {
        launch(args);
    }
     
}
