package trywith.resources;

import java.io.IOException;
import java.io.PrintWriter;

public class PrintWriterExample {

	public static void main(String[] args) {
		String path = "MyFormattedFile.txt";
		// printWriter will be auto-closed one the try block completes execution
		try (PrintWriter printWriter = new PrintWriter(path);) {
			printWriter.println("This is being written to a file.");

			for (int i = 0; i < 10; i++) {
				printWriter.printf("%d%n", i);
			}
		} catch (IOException e) {
			System.out.printf("File is not opened. Exception occurred..%s%n", e);
		}
		
		System.out.printf("Content written to %s file", path);
	}
}