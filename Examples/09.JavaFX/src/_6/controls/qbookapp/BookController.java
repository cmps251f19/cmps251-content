package _6.controls.qbookapp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Callback;

public class BookController {
   // instance variables for interacting with GUI
   @FXML private ListView<Book> booksListView;
   @FXML private ImageView coverImageView;
   @FXML private CheckBox showBookIconCheckbox;

   // stores the list of Book Objects
   private ObservableList<Book> booksOL = null;

   // initialize controller
   public void initialize() {
      // populate the ObservableList<Book>
	  booksOL = FXCollections.observableArrayList(BookRespository.getBooks());
      booksListView.setItems(booksOL); // bind booksListView to books

      // when ListView selection changes, show large cover in ImageView
      booksListView.getSelectionModel().selectedItemProperty().
         	addListener((observable, oldValue, newValue) -> {                        
                  coverImageView.setImage(
                     new Image(newValue.getLargeImage()));
            }
      );
   } 
   
   @FXML
   void handleShowBookIcon(ActionEvent event) {
	   if (showBookIconCheckbox.isSelected()) {
		   // Set custom ListView cell factory that displays an Image and text
		   booksListView.setCellFactory( c -> new ImageTextCell() );
	   } else {
		   booksListView.setCellFactory(null);	
	   }
   }
}