package paths;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathsExample {

	public static void main(String[] args) {
		Path path = Paths.get("data/countries.json").toAbsolutePath();
		System.out.printf("Absolute Path: %s%n", path);
		System.out.printf("getFileName: %s%n", path.getFileName());
		System.out.printf("getParent: %s%n", path.getParent());
		System.out.printf("getRoot: %s%n", path.getRoot());
	}
}