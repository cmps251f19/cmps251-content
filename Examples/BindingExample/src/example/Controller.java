package example;

import java.text.NumberFormat;

import javafx.fxml.FXML;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private Slider progressSlider;

    @FXML
    private TextField progressTextField;

    @FXML
    private ProgressIndicator progressIndicator;
    
    public void initialize() {
    	progressIndicator.progressProperty().bind(progressSlider.valueProperty().divide(100));
    	progressTextField.textProperty().bindBidirectional(progressSlider.valueProperty(), 
    			NumberFormat.getNumberInstance());
    	
    	/*progressSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
    		progressIndicator.setProgress(newValue.doubleValue() / 100);
    		progressTextField.setText(String.valueOf(newValue.intValue()));
    	});
    	
    	progressTextField.textProperty().addListener((doNotCare, oldValue, newValue) -> {
    		progressSlider.setValue(Double.valueOf(newValue));
    	}); */
    }

}
