package _12.terminal.operations;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class TerminalOperations
{
   public static void main(String[] args) throws IOException
   {
	   String filePath = "data/countries.txt";
	   List<String> content = Files.readAllLines(Paths.get(filePath), StandardCharsets.UTF_8);
      
      Stream<String> countries = content.stream();
      
      String result = countries.parallel()
         .filter(w -> w.length() <= 5)
         .filter(w -> w.startsWith("Q"))
         //.filter(w -> w.endsWith("r"))
         .findFirst()
         .orElse("None found");
      // Note the use of findAny. Run this program several times
      // and check whether the result changes
      System.out.println("A country name starting with Q: " + result);

      countries = content.stream();
      Optional<String> result2 = countries.max((v, w) -> v.length() - w.length());
      System.out.print("The longest country name: ");
      result2.ifPresent(w -> System.out.println(w));

      countries = content.stream();
      boolean result3 = countries.anyMatch(w -> w.contains("Q"));
      
      System.out.println("Is there a country with a name contains Q: " + result3);
   }
}

      
      
      
