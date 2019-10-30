package _6.controls.radiobutton;
// Controller for the Painter app
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

public class PainterController {
   // enum representing pen sizes
   private enum PenSize {
      SMALL(2), 
      MEDIUM(4), 
      LARGE(6);
      
      private final int radius;
      
      PenSize(int radius) {this.radius = radius;}
      
      public int getRadius() {return radius;}
   };

   // instance variables that refer to GUI components
   @FXML private RadioButton blackRadioButton;
   @FXML private RadioButton redRadioButton;
   @FXML private RadioButton greenRadioButton;
   @FXML private RadioButton blueRadioButton;
   @FXML private RadioButton smallRadioButton;
   @FXML private RadioButton mediumRadioButton;
   @FXML private RadioButton largeRadioButton;
   @FXML private Pane drawingAreaPane;
   @FXML private ToggleGroup colorToggleGroup;
   @FXML private ToggleGroup sizeToggleGroup;

   // instance variables for managing Painter state
   private PenSize radius = PenSize.MEDIUM; // radius of circle
   private Paint brushColor = Color.BLACK; // drawing color
   
   // set user data for the RadioButtons
   public void initialize() {
      // user data on a control can be any Object
      blackRadioButton.setUserData(Color.BLACK);
      redRadioButton.setUserData(Color.RED);
      greenRadioButton.setUserData(Color.GREEN);
      blueRadioButton.setUserData(Color.BLUE);
      smallRadioButton.setUserData(PenSize.SMALL);
      mediumRadioButton.setUserData(PenSize.MEDIUM);
      largeRadioButton.setUserData(PenSize.LARGE);      
   }
   
   // handles drawingArea's onMouseDragged MouseEvent
   @FXML
   private void drawingAreaMouseDragged(MouseEvent e) {
      Circle newCircle = new Circle(e.getX(), e.getY(), 
         radius.getRadius(), brushColor);
      drawingAreaPane.getChildren().add(newCircle); 
   }
   
   // handles color RadioButton's ActionEvents
   @FXML
   private void colorRadioButtonSelected(ActionEvent e) {
      // user data for each color RadioButton is the corresponding Color
      brushColor = 
         (Color) colorToggleGroup.getSelectedToggle().getUserData();
   } 
      
   // handles size RadioButton's ActionEvents
   @FXML
   private void sizeRadioButtonSelected(ActionEvent e) {
      // user data for each size RadioButton is the corresponding PenSize
      radius = 
         (PenSize) sizeToggleGroup.getSelectedToggle().getUserData();
   } 
      
   // handles Undo Button's ActionEvents
   @FXML
   private void undoButtonPressed(ActionEvent event) {
      int count = drawingAreaPane.getChildren().size();

      // if there are any shapes remove the last one added
      if (count > 0) {
         drawingAreaPane.getChildren().remove(count - 1);
      }
   }
   
   // handles Clear Button's ActionEvents
   @FXML
   private void clearButtonPressed(ActionEvent event) {
      drawingAreaPane.getChildren().clear(); // clear the canvas
   }
}