package _8.binding.aslider;

import java.net.URL;
import java.text.NumberFormat;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    private ProgressIndicator progressIndicator;
    @FXML
    private Slider progressSlider;
    @FXML
    private TextField progressTextField;
    @FXML
    private Label progressLabel;

    
    //Version 1 using property change listeners
    @FXML
    public void initializeV1() {
    	progressSlider.valueProperty().addListener((prop, oldVal, newVal) -> {
    		System.out.println(prop);
    		double progressValue = newVal.doubleValue();
    		progressTextField.setText( String.valueOf(newVal.intValue()) );
    		progressLabel.setText( String.format("%3.0f %% done", progressValue) );
    		progressIndicator.setProgress(progressValue / 100);
    	});
    	
    	progressTextField.textProperty().addListener((prop, oldVal, newVal) -> {
    		double progressValue = 0;
    		if (!newVal.isEmpty())
    			progressValue = Double.valueOf(newVal.toString());
    		
    		progressSlider.setValue( progressValue );
    	});
    }
    
    //Better version using property bindings
    @FXML
    public void initialize() {
        progressTextField.textProperty().bindBidirectional(progressSlider.valueProperty(),
                NumberFormat.getNumberInstance());
        progressLabel.textProperty().bind(progressTextField.textProperty().concat(" % done"));
        progressIndicator.progressProperty().bind(progressSlider.valueProperty().divide(100));
    }
}