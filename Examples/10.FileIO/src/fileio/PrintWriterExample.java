package fileio;

import java.io.IOException;
import java.io.PrintWriter;

public class PrintWriterExample {

	public static void main(String[] args) {
		String path = "data/MyFormattedFile.txt";
		try (PrintWriter out = new PrintWriter(path)) {
			out.println("This is being written to a file.");

			for (int i = 0; i < 10; i++) {
				out.printf("%d%n", i);
			}
		} catch (IOException e) {
			System.out.printf("File is not opened. Exception occurred..%s%n", e);
		}
		
		System.out.printf("Content written to %s file", path);
	}
}