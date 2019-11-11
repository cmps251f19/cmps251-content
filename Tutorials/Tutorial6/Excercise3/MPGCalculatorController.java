// MPGCalculatorController.java
// Controller that handles calculateButton and tipPercentageSlider events
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class MPGCalculatorController {
   // GUI controls defined in FXML and used by the controller's code
   @FXML 
   private TextField milesTextField; 

   @FXML
   private TextField gallonsTextField;

   @FXML
   private TextField mpgTextField;

   // calculates and displays the tip and total amounts
   @FXML
   private void calculateButtonPressed(ActionEvent event) {
      double miles = Double.parseDouble(milesTextField.getText());
      double gallons = Double.parseDouble(gallonsTextField.getText());

      mpgTextField.setText(String.format("%.2f", miles / gallons));
   }
}

/**************************************************************************
 * (C) Copyright 1992-2018 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/
