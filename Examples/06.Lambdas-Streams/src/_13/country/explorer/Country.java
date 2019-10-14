package _13.country.explorer;

public class Country {
    private String code;
    private String name;
    private String capital;
    private String continent;
    private String region;
    private long population;
    private double area;

    public Country(String code, String name, String capital, String continent, String region, long population,
			double area) {
		this.code = code;
		this.name = name;
		this.capital = capital;
		this.continent = continent;
		this.region = region;
		this.population = population;
		this.area = area;
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

	public String getRegion() {
		return region;
	}

	public long getPopulation() {
		return population;
	}

	public double getArea() {
		return area;
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

	public void setRegion(String region) {
		this.region = region;
	}

	public void setPopulation(long population) {
		this.population = population;
	}

	public void setArea(double area) {
		this.area = area;
	}

	public String toString() {
		//return JsonUtil.toJson(this);
		return String.format("%-20s | %-8s |%-18s | People: %,14d | Area: %,10.2f", name, continent, region, population, area);
	}
}
