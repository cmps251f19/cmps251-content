package _13.country.explorer;

import utils.JsonUtil;

public class Country {
    private String code;
    private String name;
    private String capital;
    private String continent;
    private long population;
    
	public Country(String code, String name, String capital, String continent, long population) {
		super();
		this.code = code;
		this.name = name;
		this.capital = capital;
		this.continent = continent;
		this.population = population;
	}
	public String getCode() {
		return code;
	}
	public String getName() {
		return name;
	}
	public String getCapital() {
		return capital;
	}
	public String getContinent() {
		return continent;
	}
	public long getPopulation() {
		return population;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setCapital(String capital) {
		this.capital = capital;
	}
	public void setContinent(String continent) {
		this.continent = continent;
	}
	public void setPopulation(long population) {
		this.population = population;
	}
	
	public String toString() {
		return JsonUtil.toJson(this);
	}
}
