package _03.findfirst;
import java.util.List;
import java.util.Optional;

public class Example2FindCountry
{
   public static void main(String[] args)
   {
      List<String> countries = List.of("Australia", "Switzerland",
         "Madagascar", "Morocco", "Qatar", "France");
      
      Optional<String> result = countries.stream().filter(c -> c.length() == 5).findFirst();

      // Using isPresent/get
      if (result.isPresent())
      {
         System.out.println("The first country with more than 10 characters: " + result.get());
      }
      else
      {
         System.out.println("None of these countries has more than 10 characters");
      }
      
      // Using ifPresent
      result.ifPresent(v -> System.out.println(
            "The first country with more than 10 characters: " + v));

      // Using orElse
      String first = countries.stream().filter(c -> c.length() > 10).findFirst().orElse("None");
      System.out.println("The first country with more than 10 characters: " + first);
   }
}
