package _9.binding;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

/**
 *
 * @author jwright
 */
public class FXMLDocumentController implements Initializable {
    
    //These items are for the CheckBox example
    @FXML private Label pizzaOrderLabel;
    @FXML private CheckBox pepperoniCheckBox;
    @FXML private CheckBox pineappleCheckBox;
    @FXML private CheckBox baconCheckBox;
    
    //These items are for the ChoiceBox example
    @FXML private ChoiceBox choiceBox;
    @FXML private Label choiceBoxLabel;
    
    //These items are for the ComboBox example
    @FXML private ComboBox comboBox;
    @FXML private Label comboBoxLabel;
    
    //These items are for the RadioButton example
    @FXML private RadioButton phpRadioButton;
    @FXML private RadioButton javaRadioButton;
    @FXML private RadioButton cSharpRadioButton;
    @FXML private RadioButton cPlusPlusRadioButton;
    @FXML private Label radioButtonLabel;
    private ToggleGroup favLangToggleGroup;
    
    
    //These items are for the ListView and TextArea example
    @FXML private ListView listView;
    @FXML private TextArea golfTextArea;
    
    /**
     * When this method is called, it will change the Scene to 
     * a TableView example
     */
    public void changeScreenButtonPushed(ActionEvent event) throws IOException
    {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("TableView.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        
        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(tableViewScene);
        window.show();
    }
    
    
    /**
     * This will update the Label for the ChoiceBox
     */
    public void choiceBoxButtonPushed()
    {
        choiceBoxLabel.setText("My favourite fruit is:\n"+choiceBox.getValue().toString());
    }
    
    
    /**
     * This is for the CheckBox example
     */
    public void pizzaOrderButtonPushed()
    {
        String order = "Toppings are:";
        
        if (pineappleCheckBox.isSelected())
            order += "\npineapple";

        if (pepperoniCheckBox.isSelected())
            order += "\npepperoni";
        
        if (baconCheckBox.isSelected())
            order += "\nbacon";

        this.pizzaOrderLabel.setText(order);
    }
    
    /**
     * This method will update the radioButtonLabel when ever a different
     * radio button is pushed
     */
    public void radioButtonChanged()
    {
        if (this.favLangToggleGroup.getSelectedToggle().equals(this.cPlusPlusRadioButton))
            radioButtonLabel.setText("The selected item is: C++");
        
        if (this.favLangToggleGroup.getSelectedToggle().equals(this.cSharpRadioButton))
            radioButtonLabel.setText("The selected item is: C#");
        
        if (this.favLangToggleGroup.getSelectedToggle().equals(this.phpRadioButton))
            radioButtonLabel.setText("The selected item is: PHP");
        
        if (this.favLangToggleGroup.getSelectedToggle().equals(this.javaRadioButton))
            radioButtonLabel.setText("The selected item is: Java");
        
    }
            
    
    /**
     * This will update the comboBoxLabel when the ComboBox is changed
     */
    public void comboBoxWasUpdated()
    {
        this.comboBoxLabel.setText("Course selected: \n" + comboBox.getValue().toString());
    }
    
    
    /**
     * This method will copy the Strings from the ListView and put them in the text area
     */
     public void listViewButtonPushed()
     {
        String textAreaString = "";
        
        ObservableList listOfItems = listView.getSelectionModel().getSelectedItems();
        
        for (Object item : listOfItems)
        {
            textAreaString += String.format("%s%n",(String) item);
        }
        
        this.golfTextArea.setText(textAreaString);
     }
    
     
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        pizzaOrderLabel.setText("");
        
        //This items are for configuring the ChoiceBox example
        choiceBoxLabel.setText("");
        choiceBox.getItems().add("apples");
        choiceBox.getItems().add("bananas");
        choiceBox.getItems().addAll("oranges","pears","strawberries");
        choiceBox.setValue("apples");
        
        //this items are for configuring the ComboBox
        comboBox.getItems().add("COMP1030");
        comboBox.getItems().addAll("COMP1008","MGMT2003","MGMT2010");
        comboBox.setVisibleRowCount(3);
        comboBox.setEditable(true);
        comboBox.setPromptText("Choose Course");
        comboBoxLabel.setText("");
        
        //These items are for configuring the RadioButtons
        radioButtonLabel.setText("");
        favLangToggleGroup = new ToggleGroup();
        this.cPlusPlusRadioButton.setToggleGroup(favLangToggleGroup);
        this.cSharpRadioButton.setToggleGroup(favLangToggleGroup);
        this.phpRadioButton.setToggleGroup(favLangToggleGroup);
        this.javaRadioButton.setToggleGroup(favLangToggleGroup);
        
        //These items are for configuring the ListArea
        listView.getItems().addAll("Golf Balls","Wedges","Irons","Tees","Driver","Putter");
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        
    }    
    
}
