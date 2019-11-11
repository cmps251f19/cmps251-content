// Exercise 25.3: Scrapbook.java
// Display four images and text
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Paul Deitel
 */
public class Scrapbook extends Application 
{  
   @Override
   public void start(Stage stage) throws Exception 
   {
      Parent root = 
         FXMLLoader.load(getClass().getResource("Album.fxml"));
      
      Scene scene = new Scene(root);
      
      stage.setScene(scene);
      stage.show();
   }

   public static void main(String[] args) 
   {
      launch(args);
   }
}
