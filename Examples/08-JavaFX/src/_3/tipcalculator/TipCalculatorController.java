package _3.tipcalculator;
// Controller that handles calculateButton and tipPercentageSlider events
import java.math.RoundingMode;
import java.text.NumberFormat;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

public class TipCalculatorController { 
   // formatters for currency and percentages
   private static final NumberFormat currency = 
      NumberFormat.getCurrencyInstance();
   private static final NumberFormat percent = 
      NumberFormat.getPercentInstance();
   
   private Double tipPercentage = 0.15; // 15% default
   
   // GUI controls defined in FXML and used by the controller's code
   @FXML 
   private TextField amountTextField; 

   @FXML
   private Label tipPercentageLabel; 

   @FXML
   private Slider tipPercentageSlider;

   @FXML
   private TextField tipTextField;

   @FXML
   private TextField totalTextField;

   // calculates and displays the tip and total amounts
   @FXML
   private void calculateButtonPressed(ActionEvent event) {
      try {
         Double amount = Double.valueOf(amountTextField.getText());
         Double tip = amount * tipPercentage;
         Double total = amount + tip;

         tipTextField.setText(currency.format(tip));
         totalTextField.setText(currency.format(total));
      }
      catch (NumberFormatException ex) {
         amountTextField.setText("Enter amount");
         amountTextField.selectAll();
         amountTextField.requestFocus();
      }
   }

   // called by FXMLLoader to initialize the controller
   public void initialize() {
      // 0-4 rounds down, 5-9 rounds up 
      currency.setRoundingMode(RoundingMode.HALF_UP);
      
      // listener for changes to tipPercentageSlider's value
      tipPercentageSlider.valueProperty().addListener((prop, oldValue, newValue) -> {
               tipPercentage = Double.valueOf(newValue.intValue() / 100.0);
               tipPercentageLabel.setText(percent.format(tipPercentage));
         }
      );
   }
}
