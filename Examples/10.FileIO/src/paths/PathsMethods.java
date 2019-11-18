package paths;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PathsMethods {

	public static void main(String[] args) {
		System.out.println(".json Files in data folder:");
		printPathsInFolder("data", 
					f -> f.getFileName().toString().endsWith(".json") 
		);
		
		//List all files
		String path = "D:\\cmps251\\cmps251-content";
		try {
			List<String> files = Files.walk(Paths.get(path))
									  .filter(Files::isRegularFile)
									  .map(f -> f.toString())
									  .filter(f -> f.endsWith(".java"))
									  .collect(Collectors.toList());
			
			System.out.printf("%nThere are %d .java files in %s%n", files.size(), path);
			
			files.forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//List all folders
		path = "D:\\cmps251\\cmps251-content";
		try {
			List<String> folders = Files.walk(Paths.get(path))
										.filter(Files::isDirectory)
										.map(f -> f.toString())
										.collect(Collectors.toList());
			
			System.out.printf("%nThere are %d folders in %s%n", folders.size(), path);
			
			//foldersList.forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}
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
