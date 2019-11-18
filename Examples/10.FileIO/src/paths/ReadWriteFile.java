package paths;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.nio.file.StandardOpenOption.CREATE;
import static java.nio.file.StandardOpenOption.APPEND;

public class ReadWriteFile {

	public static void main(String[] args) {
		String inputFileName = "data/countries.txt";
		String outputFileName = "data/me-countries.txt";
		List<String> countries;
		try {
			countries = Files.lines(Paths.get(inputFileName))
							 .filter(c -> c.contains("Middle East"))
							 .map(c -> c.split(";")[0])
							 .sorted()
							 .collect(Collectors.toList());

			System.out.println(countries);
			//In case we want to append to the file instead of overwrite we can pass these option
			OpenOption[] options = new OpenOption[] { CREATE, APPEND };
			
			Files.write(Paths.get(outputFileName), countries, options);
			
			System.out.printf("%nThere are %d letters in %s", 
						countFileLetters(inputFileName),
						inputFileName);
			
			createTestFile();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static long countFileLetters(String inputFileName) throws IOException {
		return Files.lines(Paths.get(inputFileName))
					.mapToInt(String::length)
					.sum();
	}
	
	private static void createTestFile() throws IOException {
			Path path = Paths.get("data/testFile.txt");
			List<String> lines =
					List.of("Line One", "Line Two", "Final Line");
			Files.write(path, lines);
	}
}