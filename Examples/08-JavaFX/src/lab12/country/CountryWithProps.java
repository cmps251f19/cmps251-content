package lab12.country;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class CountryWithProps {
    private StringProperty code;
    private StringProperty name;
    private StringProperty capital;
    private StringProperty continent;
    private StringProperty region;
    private LongProperty population;
    private DoubleProperty area;

    public StringProperty codeProperty() { return code; }
    public StringProperty nameProperty() { return name; }
    public StringProperty capitalProperty() { return capital; }
    public StringProperty continentProperty() { return continent; }
    public StringProperty regionProperty() { return region; }
    public LongProperty populationProperty() { return population; }
    public DoubleProperty areaProperty() { return area; }
    
    public CountryWithProps(String code, String name, String capital, String continent, String region, long population,
			double area) {
		this.code = new SimpleStringProperty(code);
		this.name = new SimpleStringProperty(name);
		this.capital = new SimpleStringProperty(capital);
		this.continent = new SimpleStringProperty(continent);
		this.region = new SimpleStringProperty(region);
		this.population = new SimpleLongProperty(population);
		this.area = new SimpleDoubleProperty(area);
	}
       
	public String getCode() {
		return code.getValue();
	}

	public String getName() {
		return name.getValue();
	}

	public String getCapital() {
		return capital.getValue();
	}

	public String getContinent() {
		return continent.getValue();
	}

	public String getRegion() {
		return region.getValue();
	}

	public long getPopulation() {
		return population.getValue();
	}

	public double getArea() {
		if (area == null)
			return 0;
		else 
			return area.getValue();
	}

	public void setCode(String code) {
		this.code.setValue(code);
	}

	public void setName(String name) {
		this.name.setValue(name);
	}

	public void setCapital(String capital) {
		this.capital.setValue(capital);
	}

	public void setContinent(String continent) {
		this.continent.setValue(continent);
	}

	public void setRegion(String region) {
		this.region.setValue(region);
	}

	public void setPopulation(long population) {
		this.population.setValue(population);
	}

	public void setArea(double area) {
		this.area.setValue(area);
	}

	public String toString() {
		//return JsonUtil.toJson(this);
		return String.format("%-20s | %-8s |%-18s | People: %,14d | Area: %,10.2f", 
					getName(), getContinent(), getRegion(), 
					getPopulation(), getArea() );
	}
}
