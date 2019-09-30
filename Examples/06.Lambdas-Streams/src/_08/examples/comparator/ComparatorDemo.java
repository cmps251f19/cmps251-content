package _08.examples.comparator;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class ComparatorDemo
{
   public static void main(String[] args) throws IOException
   {
      Comparator<String> comp = Comparator.comparing(t -> t.length());
      String[] words = "The quick brown fox jumps over the lazy dog".split(" ");
      Arrays.sort(words, comp);
      System.out.println(Arrays.toString(words));

      Arrays.sort(words, Comparator.comparing(String::length));
      System.out.println(Arrays.toString(words));

      try (Stream<String> lines = Files.lines(Paths.get("D:\\cmps251\\data\\population.txt")))
      {
         List<Country> result = lines
            .map(line -> Country.parse(line))
            .sorted(Comparator
               .comparing(Country::getContinent)
               .thenComparing(Country::getName))
            .collect(Collectors.toList());
         
         System.out.println(result);
      }
   }
}
