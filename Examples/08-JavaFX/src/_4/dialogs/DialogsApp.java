package _4.dialogs;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DialogsApp extends Application {
   @Override
   public void start(Stage stage) throws Exception {
      Parent root = FXMLLoader.load(getClass().getResource("Dialogs.fxml"));

      Scene scene = new Scene(root);
      stage.setScene(scene);
      stage.setTitle("JavaFX Dialogs");
      stage.show();
   }

   public static void main(String[] args) {
      launch(args); 
   }
}