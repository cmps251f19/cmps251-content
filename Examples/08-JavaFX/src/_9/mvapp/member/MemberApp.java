package _9.mvapp.member;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MemberApp extends Application {

    @Override
    public void start(Stage stage) throws Exception{
        Pane root = FXMLLoader.load(getClass().getResource("MembersView.fxml"));
        stage.setScene(new Scene(root, 800, 500));
        stage.setTitle("Member App");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
