package _02.map.filter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class Example2LongName
{
   public static void main(String[] args) throws IOException
   {
	  String filePath = "data/countries.txt";
	  Stream<String> countries = Files.lines(Paths.get(filePath));
      //long count = 
	  countries.filter(c -> c.length() > 20)
	  		.forEach(System.out::println);
	  		//.count();

      //System.out.println("Countries with long name: " + count);
      countries.close();
   }
}
