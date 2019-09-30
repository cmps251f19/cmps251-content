package _08.examples;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class _2CountriesLongName
{
   public static void main(String[] args) throws IOException
   {
      try (Stream<String> lines = Files.lines(Paths.get("D:\\cmps251\\data\\countries.txt"))) 
      { // Read the lines
         List<String> result = lines
            .filter(w -> w.length() > 10) // Keep only long words
            .map(w -> w.substring(0, 1).toUpperCase() + w.substring(1)) // Add ellipses
            .distinct() // Remove duplicates
            .limit(20) // Keep only the first twenty
            .collect(Collectors.toList()); // Collect into a list
         System.out.println(result);
      }
   }
}
