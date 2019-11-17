package _9.mvapp.surah;

import java.util.List;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class SurahController {
	IntegerProperty rowCountProperty = new SimpleIntegerProperty(0);
	
    @FXML
    private ComboBox<String> surahTypeCombo;

    @FXML
    private TableView<Surah> surahTable;

    @FXML
    private TableColumn<Surah, Integer> idCol;

    @FXML
    private TableColumn<Surah, String> nameCol;

    @FXML
    private TableColumn<Surah, String> englishNameCol;

    @FXML
    private TableColumn<Surah, Integer> ayaCountCol;

    @FXML
    private TableColumn<Surah, String> typeCol;
    
    @FXML
    private Label messageLabel;

    @FXML
    void handleAyaTypeChanged(ActionEvent event) {
    	String selectedType = surahTypeCombo.getSelectionModel().getSelectedItem();
    	System.out.printf("Selected Type: %s %n", selectedType);
    	
    	List<Surah> surahs = SurahRepository.getSurahs(selectedType);
    	ObservableList<Surah> surahsOL = FXCollections.observableArrayList(surahs);
    	surahTable.setItems(surahsOL);
    	rowCountProperty.set(surahsOL.size());
    }
    
    //Auto called when the view is created
    public void initialize() {
    	List<String> surahTypes = SurahRepository.getSurahTypes();
    	ObservableList<String> surahTypesOL = FXCollections.observableArrayList(surahTypes);
    	surahTypeCombo.setItems(surahTypesOL);
    	surahTypeCombo.setValue("All");
    	handleAyaTypeChanged(null);    	
    	messageLabel.textProperty().bind(
    			surahTable.getSelectionModel()
    				.selectedIndexProperty().add(1).asString()
    				.concat(rowCountProperty.asString(" of %d")));
    	
    	//Link table columns to Surah attributes
    	/*A TableColumn must have a cell value factory to extracts from 
    	the object the value to be displayed in each cell (on each row) in the column. */
    	idCol.setCellValueFactory(new PropertyValueFactory("id"));
    	nameCol.setCellValueFactory(new PropertyValueFactory("name"));
    	englishNameCol.setCellValueFactory(new PropertyValueFactory("englishName"));
    	ayaCountCol.setCellValueFactory(new PropertyValueFactory("ayaCount"));
    	typeCol.setCellValueFactory(new PropertyValueFactory("type"));
    }
}