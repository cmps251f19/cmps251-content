package _6.dialogs;
import java.util.List;
import java.util.Optional;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ChoiceDialogExample extends Application {
	 
    private Label label;
 
    private void showChoiceDialog() {
 
        Book java = new Book(1, "J01", "Java Tutorial for Beginners");
        Book csharp = new Book(2, "C01", "CSharp Tutoral for Beginners");
        Book python = new Book(3, "P01", "Python for Beginners");
 
        List<Book> books = List.of(java, csharp, python);
        Book defaultBook = csharp;
 
        ChoiceDialog<Book> dialog = new ChoiceDialog<Book>(defaultBook, books);
 
        dialog.setTitle("Book Selection");
        dialog.setHeaderText("Select a Book:");
        dialog.setContentText("Book:");
 
        Optional<Book> result = dialog.showAndWait();
 
        result.ifPresent(book -> this.label.setText(book.getName()) );
    }
 
    @Override
    public void start(Stage stage) {
 
        VBox root = new VBox();
        root.setAlignment(Pos.TOP_CENTER);
        root.setSpacing(10);
 
        this.label = new Label();
 
        Button button = new Button("Select a book");
 
        button.setOnAction( event -> showChoiceDialog() );
 
        root.getChildren().addAll(button, label);
 
        Scene scene = new Scene(root, 450, 250);
        stage.setTitle("JavaFX ChoiceDialog");
        stage.setScene(scene);
 
        stage.show();
 
    }
 
    public static void main(String args[]) {
        launch(args);
    }
 
}
