package paths;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ReadAll {

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
			Files.write(Paths.get(outputFileName), countries);
			
			System.out.printf("%nThere are %d letters in %s", 
						countFileLetters(inputFileName),
						inputFileName);
			
			createTestFile();
			
			System.out.println("\n\n.json Files in data folder:");
			printPathsInFolder("data", 
						f -> f.getFileName().toString().endsWith(".json") 
					);
			
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
	
	public static void printPathsInFolder(String path, Predicate<Path> filter) {
		try {
			Files.list(Paths.get(path))
				 .filter(filter)
				 .map(f -> f.getFileName())
				 .forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*public static void printWalkPathsInFolders(String folder, String extension) throws IOException {
		Files.list(Paths.get(folder))
			 .filter(f -> f.getFileName().toString().endsWith(extension) || extension.isEmpty())
			 .forEach(path -> {
				 System.out.println(path);
				 System.out.println(Files.isDirectory(path));
				if (Files.isDirectory(path))
					printPathsInFolder(path, extension);
				else
					System.out.println(path);
			 });
	}*/
}
