package _08.comparator;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.google.gson.Gson;

public class CountryComparator {

	public static void main(String[] args) {
		Comparator<String> compareByLength = Comparator.comparing(String::length);
		
		Comparator<String> compareByLengthThenAlphabetical =
                Comparator.comparing(String::length).thenComparing(Comparator.naturalOrder());
		
		Gson gson = new Gson();
		String filePath = "data/countries.json";
		try {
			// Read file content
			String content = Files.readString(Paths.get(filePath));
			// System.out.println(content);

			// Convert json text to an array of Country objects
			List<Country> countries = Arrays.asList( gson.fromJson(content, Country[].class) );
			//countries.removeIf(c -> c.getContinent().isEmpty());

	        Comparator<Country> compareByContinentThenPopulation = 
	        		Comparator.comparing(Country::getContinent)
	                	      .thenComparing(Country::getPopulation);
	        
	        Comparator<Country> compareByContinentThenPopulationReversed = 
	        		Comparator.comparing(Country::getContinent)
	                	      .thenComparing(Country::getPopulation)
	                	      .reversed();
	        
			// Get Countries having more than 200 Ayas
			System.out.println("*** Countries sorted by continent and Population ***");
			countries.stream().filter(c -> !c.getContinent().isEmpty())
							  .filter(c -> c.getPopulation() > 1000000)
							  .filter(c -> c.getPopulation() <= 3000000)
							  .sorted(compareByContinentThenPopulationReversed)
							  .forEach(System.out::println);

		} catch (Exception e) {
			e.getMessage();
		}
	}

}
