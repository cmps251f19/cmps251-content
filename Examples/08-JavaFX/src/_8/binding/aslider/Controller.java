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
    public void initializev1() {
    	progressSlider.valueProperty().addListener((observable, oldVal, newVal) -> {
    		//System.out.printf("oldValue: %d new value: %d%n", oldVal.intValue(), newVal.intValue());
    		double progressValue = newVal.doubleValue();
    		progressTextField.setText( String.valueOf(newVal.intValue()) );
    		progressLabel.setText( String.format("%3.0f %% done", progressValue) );
    		progressIndicator.setProgress(progressValue / 100);
    	});
    	
    	progressTextField.textProperty().addListener((observable, oldVal, newVal) -> {
    		System.out.printf("oldValue: %s new value: %s %n", oldVal, newVal);
    		double progressValue = 0;
    		if (!newVal.isEmpty())
    			progressValue = Double.valueOf(newVal.toString());
    		
    		progressSlider.setValue( progressValue );
    	});
    }
    
    //Better version using property bindings
    public void initialize() {
        progressLabel.textProperty().bind(progressSlider.valueProperty().asString("%.0f %% done"));
        progressIndicator.progressProperty().bind(progressSlider.valueProperty().divide(100));
        progressTextField.textProperty().bindBidirectional(progressSlider.valueProperty(),
                NumberFormat.getNumberInstance());
    }
}