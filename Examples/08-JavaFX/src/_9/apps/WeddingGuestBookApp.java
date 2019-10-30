package _9.apps;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class WeddingGuestBookApp extends Application {
	
	@Override
	public void start(Stage mainStage) throws Exception {
		
		// gridpane is a spreadsheet-like layout
		GridPane gp = new GridPane();
		gp.setAlignment(Pos.CENTER);
		gp.setVgap(10); // vertical gap between rows
		gp.setHgap(10); // horizontal gap between columns
		gp.setPadding(new Insets(25, 25, 25, 25));
		
		Image img = new Image(getClass().getResourceAsStream("wed.png"));
		ImageView iv = new ImageView(img);
		iv.setFitHeight(100);
		iv.setPreserveRatio(true);
		gp.add(iv, 0, 0, 2, 1);
	
		Label guestName = new Label("Guest name");
		gp.add(guestName, 0, 1);
		
		TextField guestNameField = new TextField();
		gp.add(guestNameField, 1, 1);
		
		Label affiliationName = new Label("Affiliation");
		gp.add(affiliationName, 0, 2);
		
		TextField affiliationNameField = new TextField();
		gp.add(affiliationNameField, 1, 2);

		Button but = new Button("Register");
		HBox hbBut = new HBox();
		hbBut.setAlignment(Pos.BOTTOM_RIGHT);
		hbBut.getChildren().add(but);
		gp.add(hbBut, 1, 3);

		Text registrationInfo = new Text();
		HBox hbReg = new HBox();
		hbReg.setAlignment(Pos.CENTER);
		hbReg.getChildren().add(registrationInfo);
		gp.add(hbReg, 0, 4, 2, 1);

		// lambda expression approach
		but.setOnAction(e -> {
			registrationInfo.setFont(Font.font("Verdana", FontPosture.ITALIC, 12));
			registrationInfo.setFill(Color.DARKOLIVEGREEN);

			registrationInfo.setText("Thanks for coming, " + guestNameField.getText() + "!");
			try {
				// feel free to replace the file location
				File f = new File("data/wedding-guests.csv");
				try(PrintWriter pw = new PrintWriter(new FileWriter(f,true));) {
					pw.println(guestNameField.getText() + "," + affiliationNameField.getText());
				}
			} catch(IOException ex) {
				ex.printStackTrace();
			}
			// this enables fading out of registration info after 10 second
			PauseTransition delay = new PauseTransition(Duration.seconds(10));
			delay.setOnFinished(ev -> registrationInfo.setText(""));
			delay.play();
		});

		Scene sc = new Scene(gp, 320, 260);
		mainStage.setScene(sc);
		mainStage.setTitle("Welcome to Our Wedding!");
		mainStage.show();
	}

	public static void main(String[] args) {
        Application.launch(args);
    }
}