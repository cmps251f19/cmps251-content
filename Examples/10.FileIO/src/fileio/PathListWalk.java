package fileio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PathListWalk {

	public static void main(String[] args) {
		//List all files
		String path = "data";
		try {
			List<String> files = Files.list(Paths.get(path))
									  .filter(p -> p.toString().endsWith(".json"))
									  .map(p -> p.toString())
									  .collect(Collectors.toList());
			
			System.out.printf("%nThere are %d .json files in %s%n", files.size(), path);
			
			files.forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		//List all folders
		path = "D:\\cmps251\\cmps251-content";
		try {
			List<String> folders = Files.list(Paths.get(path))
										.filter(Files::isDirectory)
										.map(p -> p.toString())
										.collect(Collectors.toList());
			
			System.out.printf("%nThere are %d folders in %s%n", folders.size(), path);
			folders.forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(".java Files in cmps251-content folder:");
		path = "D:\\cmps251\\cmps251-content";
		try {
			List<String> files = Files.walk(Paths.get(path))
			 	 .filter(p -> p.getFileName().toString().endsWith(".java"))
			 	 .map(p -> p.toString())
			 	 .collect(Collectors.toList());
			
			System.out.printf("%nThere are %d .java files in %s%n", files.size(), path);
			files.forEach(System.out::println);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}