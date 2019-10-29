package _2.welcomefx;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Controller {
    @FXML
    private Label versionLabel;

    public void initialize() {
        String javaVersion = System.getProperty("java.version");
        String javafxVersion = System.getProperty("javafx.version");
        versionLabel.setText(String.format("JavaFX %s Running on Java %s", javafxVersion, javaVersion));
    }
}