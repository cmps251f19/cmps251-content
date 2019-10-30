package _7.properties;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class UIControlBinding extends Application {

    @Override
    public void start(Stage stage) {
    	HBox root = new HBox();
    	TextField searchTextField = new TextField();
    	Button searchButton = new Button("Search");
	   	Tooltip tip = new Tooltip("The search button is disabled when the search textbox is empty");
	   	searchButton.setTooltip(tip);

    	searchButton.disableProperty().bind(searchTextField.textProperty().isEmpty());
		root.getChildren().addAll(searchTextField, searchButton);
		root.setSpacing(10);
		root.setAlignment(Pos.CENTER);
		
		//Handle the click event
		searchButton.setOnAction(event -> {
			System.out.printf("Search Button Clicked!. You entered: %s %n", 
						searchTextField.getText());
		});

        Scene scene = new Scene(root, 300, 200);
        stage.setScene(scene);
        stage.setTitle("Binding Example");
        stage.show();
    }
    
	public  static void main(String args[]) {
		launch(args);
	}
}