package _8.binding.bookapp;

// Main application class that loads and displays the CoverViewer's GUI.
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

//App based of examples from Java How to Program, 11/e - Deitel.com
public class BookApp extends Application {   
   @Override
   public void start(Stage stage) throws Exception {
      Pane root = FXMLLoader.load(getClass().getResource("BookView.fxml"));
      
      Scene scene = new Scene(root);
      stage.setScene(scene);
      stage.setTitle("Cover Viewer");
      stage.show();
   }

   public static void main(String[] args) {
      launch(args);
   }
}