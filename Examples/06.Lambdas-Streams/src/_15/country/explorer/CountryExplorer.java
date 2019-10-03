package _15.country.explorer;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.google.gson.Gson;

public class CountryExplorer {

	public static void main(String[] args) {
		Gson gson = new Gson();
		String filePath = "data/countries.json";
		try {
			// Read file content
			String content = Files.readString(Paths.get(filePath));
			// System.out.println(content);

			// Convert json text to an array of Country objects
			Country[] countries = gson.fromJson(content, Country[].class);

			// Get Countries having more than 200 Ayas
			System.out.println("*** Countries by continent ***");
			Stream.of(countries).filter(c -> c.getContinent().equalsIgnoreCase("Africa"))
							 .limit(5)
							 .forEach(System.out::println);

			// Get Medinan Countries
			System.out.println("\n*** Countries Having ***");
			Stream.of(countries).filter(c -> c.getContinent().equalsIgnoreCase("Asia"))
								.filter(c -> c.getPopulation() <= 3000000)
								.forEach(System.out::println);
			
			// Get Country Count by continent
			Map<String, Long> countryCountByContinent = Stream.of(countries)
					.filter(c -> !c.getContinent().isEmpty())
					.collect(Collectors.groupingBy(c -> c.getContinent(), Collectors.counting()));
					//.collect(Collectors.groupingBy(Country::getType, Collectors.counting()));
			System.out.println(countryCountByContinent);
			
			// Get People Counts by continent
			Map<String, Long> peopleCountByContinent = Stream.of(countries)
					.filter(c -> !c.getContinent().isEmpty())
					.collect(Collectors.groupingBy(Country::getContinent, 
							 Collectors.summingLong(c-> c.getPopulation())
							));
			System.out.println(peopleCountByContinent);

		} catch (Exception e) {
			e.getMessage();
		}
	}

}
