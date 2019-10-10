package tutorial4.excercise3;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import com.google.gson.Gson;

public class CountryAtlas {
	private static List<Country> countries;
	
	private static void loadCountries() {
		Gson gson = new Gson();
		String filePath = "data/countries.json";
		try {
			// Read file content
			String fileContent = Files.readString(Paths.get(filePath));
			// System.out.println(fileContent);

			// Convert json text to an array of Country objects
			Country[] countriesArray = gson.fromJson(fileContent, Country[].class);
			//countries = Arrays.asList(countriesArray);
			countries = new ArrayList<>(List.of(countriesArray));
			countries.removeIf(c -> c.getContinent().equals("") || c.getPopulation() == 0);
			System.out.printf("%d countries loaded%n", countries.size());
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static List<Country> getCountriesByContinent(String continent) {
		// Get countries by continent
		return countries.stream()
						.filter(c -> c.getContinent().equalsIgnoreCase(continent))
						.sorted( Comparator.comparing(Country::getPopulation).reversed()) 
						.collect(Collectors.toList());
	}
	
	public static List<Country> getCountriesByRegion(String region) {
		// Get countries by region
		return countries.stream()
						.filter(c -> c.getRegion().equalsIgnoreCase(region))
						.sorted( Comparator.comparing(Country::getPopulation) ) 
						.collect(Collectors.toList());
	}
	
	public static Map<String, Long> getCountryCountByContinent() {
		// Get Country Count by continent
		 return countries.stream()
				 	     .collect( Collectors.groupingBy(Country::getContinent, 
				 			       Collectors.counting() 
				 			     ));
	}
	
	public static Map<String, Long> getPopulationByContinent() {
		// Get population by continent
		return countries.stream()
			  .collect( Collectors.groupingBy(Country::getContinent, 
				   	    Collectors.summingLong(c -> c.getPopulation())
					  ));
	}
	
	public static Country getPopulousCountry() {
		Country populousCountry =  
  			 countries.stream()
				      .max(Comparator.comparing(Country::getPopulation))
					  .get();
		return populousCountry;
	}
	
	public static Country getLeastPopulatedCountry() {
		Country populousCountry =  
  			 countries.stream()
				      .min(Comparator.comparing(Country::getPopulation))
					  .get();
		return populousCountry;
	}
	
	public static Country getLagestCountry() {
		return countries.stream()
					    .max(Comparator.comparing(Country::getArea))
						.get();
	}
	
	public static Country getSmallestCountry() {
		return countries.stream()
						.filter(c -> c.getArea() > 0)
					    .min(Comparator.comparing(Country::getArea))
						.get();
	}
	public static void main(String[] args) {
		//Load countries from countries.json into countries list 
		loadCountries();

		System.out.println("*** Top 5 populated countries by continent ***");
		getCountriesByContinent("Asia").stream().limit(5).forEach(System.out::println);
		
		System.out.println("\n*** Top 5 least populated countries by region ***");
		getCountriesByRegion("Western Asia").stream().limit(5).forEach(System.out::println);
		
		System.out.println("\n*** Country count by continent ***");
		Map<String, Long> countryCountByContinent = getCountryCountByContinent();
		System.out.println(countryCountByContinent);
			
		System.out.println("\n*** Population by continent ***");
		Map<String, Long> populationByContinent = getPopulationByContinent();
		populationByContinent.forEach(
				(continent, population) -> 
				   System.out.printf("%-8s = %,15d %n", continent, population));
		
		System.out.println("\n*** Population by continent sorted ***");
		populationByContinent.entrySet().stream()
					  .sorted(Comparator.comparing(Map.Entry::getValue))
					  .forEach( entry -> 
					  	  System.out.printf("%-8s = %,15d %n", entry.getKey(), entry.getValue()));

		System.out.println("\n*** Country with the highest population ***");
		Country populousCountry = getPopulousCountry();
		System.out.println(populousCountry);

		System.out.println("\n*** Country with least Population ***");
		Country lowestPopulation = getLeastPopulatedCountry();
		System.out.println(lowestPopulation);
		
		System.out.println("\n*** Lagest country (with biggest area) ***");
		Country largestCountry = getLagestCountry();
		System.out.println(largestCountry);

		System.out.println("\n*** Smallest country (with smallest area) ***");
		Country smallestCountry = getSmallestCountry();
		System.out.println(smallestCountry);
	}
}