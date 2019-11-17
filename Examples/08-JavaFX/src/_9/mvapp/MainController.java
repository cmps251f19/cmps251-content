package _9.mvapp;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class MainController {

    @FXML
    private BorderPane borderPane;

    @FXML
    void handleMembersRegister(ActionEvent event) {
        borderPane.setCenter( loadPane("member/MembersView.fxml") );
    }

    @FXML
    void handleSurahExplorer(ActionEvent event) {
    	borderPane.setCenter( loadPane("surah/SurahView.fxml") );
    }
    
    private Pane loadPane(String fxmlPath) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
        Pane pane = null;
		try {
			pane = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return pane;
    }
    
    //Auto called when the view is created
    public void initialize() {
    	//By default load the members register
    	handleMembersRegister(null);
    }
}