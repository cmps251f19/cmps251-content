package lab12.country;

import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class CountryController {
    @FXML
    private ComboBox<String> continentCombo;

    @FXML
    private ComboBox<String> regionCombo;

    @FXML
    private TableView<Country> countryTable;

    @FXML
    private TableColumn<Country, String> codeCol;

    @FXML
    private TableColumn<Country, String> nameCol;

    @FXML
    private TableColumn<Country, String> capitalCol;

    @FXML
    private TableColumn<Country, String> continentCol;

    @FXML
    private TableColumn<Country, String> regionCol;

    @FXML
    private TableColumn<Country, Long> populationCol;

    @FXML
    private TableColumn<Country, Double> areaCol;

    @FXML
    void handleContinentChanged(ActionEvent event) {
    	String selectedContinent = continentCombo.getSelectionModel().getSelectedItem();
    	List<String> regions = CountryRespository.getRegions(selectedContinent);
    	ObservableList<String> regionsOL = FXCollections.observableArrayList(regions);
    	regionCombo.setItems(regionsOL);
    }

    @FXML
    void handleRegionChanged(ActionEvent event) {
    	String selectedRegion = regionCombo.getSelectionModel().getSelectedItem();
    	System.out.printf("Select Region: %s %n", selectedRegion);
    	if (selectedRegion == null) {
    		countryTable.setItems(null);
    		return;
    	}
    	
    	List<Country> countries = CountryRespository.getCountriesByRegion(selectedRegion);
    	ObservableList<Country> countriesOL = FXCollections.observableArrayList(countries);
    	countryTable.setItems(countriesOL);
    }
    
    //Auto called when the view is created
    public void initialize() {
    	CountryRespository.loadCountries();
    	List<String> continents = CountryRespository.getContinents();
    	ObservableList<String> continentsOL = FXCollections.observableArrayList(continents);
    	continentCombo.setItems(continentsOL);
    	
    	//Link table columns to Country attributes
    	/*A TableColumn must have a cell value factory to extracts from 
    	the object the value to be displayed in each cell (on each row) in the column. */
    	codeCol.setCellValueFactory(new PropertyValueFactory("code"));
    	nameCol.setCellValueFactory(new PropertyValueFactory("name"));
    	capitalCol.setCellValueFactory(new PropertyValueFactory("capital"));
    	continentCol.setCellValueFactory(new PropertyValueFactory("continent"));
    	regionCol.setCellValueFactory(new PropertyValueFactory("region"));
    	populationCol.setCellValueFactory(new PropertyValueFactory("population"));
    	areaCol.setCellValueFactory(new PropertyValueFactory("area")); 
    }
}