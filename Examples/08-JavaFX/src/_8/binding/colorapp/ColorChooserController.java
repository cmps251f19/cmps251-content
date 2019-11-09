package _8.binding.colorapp;

import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class ColorChooserController {
   // instance variables for interacting with GUI components
   @FXML private Slider redSlider;
   @FXML private Slider greenSlider;
   @FXML private Slider blueSlider;
   @FXML private Slider alphaSlider;
   @FXML private TextField redTextField;  
   @FXML private TextField greenTextField;
   @FXML private TextField blueTextField; 
   @FXML private TextField alphaTextField;
   @FXML private Rectangle colorRectangle;

   // instance variables for storing selected color values 
   private int red = 0;
   private int green = 0;
   private int blue = 0;
   private double alpha = 1.0;
   
   public void initialize() {
      // bind TextField values to corresponding Slider values
      redTextField.textProperty().bind(              
         redSlider.valueProperty().asString("%.0f"));
      greenTextField.textProperty().bind(
         greenSlider.valueProperty().asString("%.0f"));
      blueTextField.textProperty().bind(
         blueSlider.valueProperty().asString("%.0f"));
      alphaTextField.textProperty().bind(
         alphaSlider.valueProperty().asString("%.2f"));
      
      // listeners that set Rectangle's fill based on Slider changes
      redSlider.valueProperty().addListener((observable, oldValue, newValue) -> {    
               red = newValue.intValue();                                 
               colorRectangle.setFill(Color.rgb(red, green, blue, alpha));
          }
      );
      
      greenSlider.valueProperty().addListener((observable, oldValue, newValue) -> {                         
               green = newValue.intValue();
               colorRectangle.setFill(Color.rgb(red, green, blue, alpha));
            }
      );
      
      blueSlider.valueProperty().addListener((observable, oldValue, newValue) -> {                       
               blue = newValue.intValue();
               colorRectangle.setFill(Color.rgb(red, green, blue, alpha));
            }
      );
      
      alphaSlider.valueProperty().addListener((observable, oldValue, newValue) -> {                       
               alpha = newValue.doubleValue();
               colorRectangle.setFill(Color.rgb(red, green, blue, alpha));
            }
      );                                                                  
   }     
}