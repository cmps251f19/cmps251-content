package _05.findfirst;
import java.util.List;
import java.util.Optional;

public class Example2
{
   public static void main(String[] args)
   {
      List<String> words = List.of("Zimbabwe", "Namibia",
         "Uganda", "Botswana", "Madagascar", "Mozambique",
         "Qatar", "France", "Togo");
      
      Optional<String> result = words.stream().filter(w -> w.length() > 10).findFirst();

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
      String first = words.stream().filter(w -> w.length() > 10).findFirst().orElse("None");
      System.out.println("The first country with more than 10 characters: " + first);
   }
}
