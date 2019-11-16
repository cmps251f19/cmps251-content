package custom.exception2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import custom.exception.NotFoundException;

public class FileUtils {

	//I can handle FileNotFoundException in this method and
	//throw my own NotFoundException
	public static boolean isLineExists(String filePath, String lineToSearch) 
			throws FileNotFoundException { 
		boolean matchFound = false;
		try (Scanner inputFile = new Scanner(new FileInputStream(filePath))) {
			String line;
			while (inputFile.hasNext()) {
				line = inputFile.nextLine();
				if (line.equalsIgnoreCase(lineToSearch)) {
					matchFound = true;
					break;
				}
			}
		} 
		return matchFound;
	}
	
	//I can handle FileNotFoundException in this method and
	//throw my own NotFoundException
	public static List<String> queryFile(String filePath,
			Map<Integer, String> queryArgs, boolean ignoreFirstLine,
			boolean stopQueryAfterFirstMatch) 
			throws NotFoundException, FileNotFoundException { 

		List<String> resultLines = new ArrayList<>();
		try (Scanner inputFile = new Scanner(new FileInputStream(filePath))) {
			String line;
			int lineCount = 0;
			while (inputFile.hasNext()) {
				line = inputFile.nextLine();
				lineCount++;
				if (line.trim().isEmpty() || (ignoreFirstLine && lineCount == 1))
					continue;

				String[] lineParts = line.split(",");
				boolean matchFound = false;
				for (int i : queryArgs.keySet())
					matchFound = lineParts[i].equalsIgnoreCase(queryArgs.get(i));

				if (matchFound) {
					resultLines.add(line);
					if (stopQueryAfterFirstMatch)
						break;
				}
			}
		} 
		/*catch (FileNotFoundException e) {
			throw new NotFoundException("Source file '" + filePath + "' not found", e);
		}*/

		if (resultLines.isEmpty())
			throw new NotFoundException(
					"Not lines matched your query arguments");
		else
			return resultLines;
	}

	public static List<String> readFileOldWay(String filePath) throws FileNotFoundException {
		List<String> fileLines = new ArrayList<>();
		Scanner inputFile = null;
		try {
			inputFile = new Scanner(new FileInputStream(filePath));
			String line;
			while (inputFile.hasNext()) {
				line = inputFile.nextLine();
				// ignore empty lines
				if (!line.trim().isEmpty())
					fileLines.add(line);
			}
		} 
		finally {
			if (inputFile != null)
				inputFile.close();
		}
		return fileLines;
	}

	public static List<String> readFile(String filePath) {
		List<String> fileLines = new ArrayList<>();
		try (Scanner inputFile = new Scanner(new FileInputStream(filePath))) {
			String line;
			while (inputFile.hasNext()) {
				line = inputFile.nextLine();
				// ignore empty lines
				if (!line.trim().isEmpty())
					fileLines.add(line);
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return fileLines;
	}

	public static void appendToFile(String filePath, String textToAppend) 
			throws IOException, AlreadyExistsException {
		if (isLineExists(filePath, textToAppend)) {
			throw new AlreadyExistsException("The line to be add already exists", textToAppend, filePath + "'");
		}
		writeToFile(filePath, textToAppend, true);
	}

	/*
	 * Writes a List of Strings to a File. If append parameter is true then the
	 * lines will be added at the end of the file otherwise the file will be
	 * re-created -old file will be replaced if exists- This method can be used
	 * to replace the content of a file
	 */
	public static void writeToFile(String filePath, List<String> linesToWrite,
			boolean append) throws IOException {
		try (PrintWriter outputFile = new PrintWriter(new FileWriter(filePath, append))) {
			for (String lineToAppend : linesToWrite)
				outputFile.println(lineToAppend);
		} 
	}

	// Same as previous method but receives one line instead of a List of lines
	public static void writeToFile(String filePath, String lineToWrite,
			boolean append) throws IOException {
		try (PrintWriter outputFile = new PrintWriter(new FileWriter(filePath, append))) {
			outputFile.println(lineToWrite);
		} 
	}
	
	public static int deleteFromFile(String filePath,
			Map<Integer, String> queryArgs, boolean onlyDeleteFirstMatch)
					throws IOException, NotFoundException {
		
		int deletedCount = 0;
		String tempFileName = filePath + ".tmp";

		try (Scanner inputFile = new Scanner(new FileInputStream(filePath));
				PrintWriter outputFile = new PrintWriter(new FileWriter(tempFileName))) {
			String line;
			while (inputFile.hasNext()) {
				line = inputFile.nextLine();
				if (line.trim().isEmpty()) {
					outputFile.println(line);
					continue;
				}
				
				if (!(onlyDeleteFirstMatch && deletedCount > 0))
				{
					boolean matchFound = false;
					String[] lineParts = line.split(",");
					for (int i : queryArgs.keySet())
						matchFound = lineParts[i].equalsIgnoreCase(queryArgs.get(i));
	
					if (matchFound) {
						deletedCount++;
						//do not append to the file
						continue;
					}
				}
				
				outputFile.println(line);
			}
		}
		//Rename the temp file to the original path
		Path from = Paths.get(tempFileName);
	    Path to = Paths.get(filePath);
		Files.move(from, to, StandardCopyOption.REPLACE_EXISTING);
		
		if (deletedCount == 0)
			throw new NotFoundException("Data not found. No lines were deleted.");
		else
			return deletedCount;
	}
}
