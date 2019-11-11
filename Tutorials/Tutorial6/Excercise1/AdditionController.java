// AdditionController.java
// Controller that handles calculateButton event
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AdditionController {

    @FXML
    private TextField number1TextField;

    @FXML
    private TextField number2TextField;

    @FXML
    private Label resultLabel;

    @FXML
    void addButtonPressed(ActionEvent event) {
      try {
         int number1 = Integer.parseInt(number1TextField.getText());
         int number2 = Integer.parseInt(number2TextField.getText());
         resultLabel.setText("The sum is " + (number1 + number2));
      }
      catch (NumberFormatException ex) {
         number1TextField.setText("");
         number2TextField.setText("");
      }    
   }

   // called by FXMLLoader to initialize the controller
   public void initialize() {
      // listener for changes to number1TextField's text
      number1TextField.textProperty().addListener(
         new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> ov, 
               String oldValue, String newValue) {
               resultLabel.setText("");
            }
         }
      );

      // listener for changes to number2TextField's text
      number2TextField.textProperty().addListener(
         new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> ov, 
               String oldValue, String newValue) {
               resultLabel.setText("");
            }
         }
      );
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
