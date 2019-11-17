package _1.firstapp;

import javafx.application.Application;
import javafx.stage.Stage;

public class FirstApp extends Application {

	@Override
	public void start(Stage stage) {
		stage.setTitle("My First App");
		stage.show();
	}

	public  static void main(String args[]) {
		launch(args);
	}
}
