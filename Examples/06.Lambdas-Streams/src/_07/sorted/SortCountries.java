package _07.sorted;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class SortCountries
{
   public static void main(String[] args) throws IOException
   {
      try {
    	 Stream<String> fileLines = Files.lines(Paths.get("data/population.txt"));
      
    	 // Countries are compared first by continent.
    	 // If the continents are the same, they are compared by name.
         List<Country> countries = fileLines
            .map(line -> Country.parse(line))
            .sorted(Comparator.comparing(Country::getContinent)
            				  .thenComparing(Country::getName))
            .collect(Collectors.toList());
         
         countries.forEach(System.out::println);
         
         // Close the file
         fileLines.close();
         
      } catch (Exception e) {
		System.out.println(e.getMessage());
      }
	}
}
