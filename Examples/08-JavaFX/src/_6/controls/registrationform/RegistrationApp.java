package _6.controls.registrationform;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class RegistrationApp extends Application {

    @Override
    public void start(Stage stage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Registration.fxml"));
        stage.setScene(new Scene(root, 800, 500));
        stage.setTitle("Registration Form");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
