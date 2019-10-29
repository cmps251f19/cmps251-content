package _9.binding.CoverViewer;

// Main application class that loads and displays the CoverViewer's GUI.
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CoverViewer extends Application {   
   @Override
   public void start(Stage stage) throws Exception {
      Parent root = 
         FXMLLoader.load(getClass().getResource("CoverViewer.fxml"));
      
      Scene scene = new Scene(root);
      stage.setTitle("Cover Viewer");
      stage.setScene(scene);
      stage.show();
   }

   public static void main(String[] args) {
      launch(args);
   }
}