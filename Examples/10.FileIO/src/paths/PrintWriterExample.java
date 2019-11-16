package paths;

import java.io.IOException;
import java.io.PrintWriter;

public class PrintWriterExample {

	public static void main(String[] args) {
		try {
			PrintWriter out = new PrintWriter("data/MyFormattedFile.txt");
			out.println("This is being written to a file.");

			for (int i = 0; i < 10; i++) {
				out.printf("%d%n", i);
			}

			out.close();
		} catch (IOException ioe) {
			System.out.printf("File is not opened. Exception occurred..%s%n", ioe);
		}
	}
}