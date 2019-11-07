package _8.binding.binding2way;

import javafx.beans.binding.Bindings;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable
{
    @FXML
    Label lblLabel;

    @FXML
    TextField tfText;
    @FXML
    TextField tfText2;



    private final StringProperty twoWayInput = new SimpleStringProperty("default value");

    @FXML
    private void handleButtonAction(ActionEvent event)
    {
        setTwoWayInput("Pre-defined values");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        tfText.textProperty().bindBidirectional(twoWayInputProperty());
        lblLabel.textProperty().bind(twoWayInputProperty());

        Bindings.bindBidirectional(twoWayInputProperty(), tfText2.textProperty());

    }

    public String getTwoWayInput()
    {
        return twoWayInput.get();
    }

    public StringProperty twoWayInputProperty()
    {
        return twoWayInput;
    }

    public void setTwoWayInput(String twoWayInput)
    {
        this.twoWayInput.set(twoWayInput);
    }
}
