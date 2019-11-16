package custom.exception2;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import custom.exception.NotFoundException;

public class TestApp {
	public static void main(String[] args) {

		/* Example reading all lines of a file		 * 
		 */
		//Specify the Path where you placed the homework files
		String courseFilePath = "datafiles/course.csv";
		Map<Integer, String> queryArgs = new HashMap<>();
		queryArgs.put(0, "CMPS2512");
		try {
			List<String> queryResults = FileUtils.queryFile(courseFilePath, queryArgs, true, true);
			System.out.println(queryResults.get(0));
		} catch (NotFoundException e) {
			System.out.println(e.getMessage());
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		//System.exit(0);
		 
		List<String> courseFileLines = FileUtils.readFile(courseFilePath);
		int lineCount = 0;
		for (String line : courseFileLines) {
			System.out.println(line);
			lineCount++;
			
			/* Skip converting the first line to a Course object 
			because it contains the file header */
			if (lineCount == 1)
				continue;
			
			String[] lineParts = line.split(",");
			// Build a Course object from the line
			Course aCourse = new Course(lineParts[0],
					lineParts[1], lineParts[2], Integer.parseInt(lineParts[3]));
			System.out.println(aCourse);
		}
		
		/* Example of appending a line to a file		 * 
		 */
		// Append one course. 
		String newCourse = "CMPS303,Data Structures,CSE,3";
		try {
			FileUtils.appendToFile(courseFilePath, newCourse);
		} catch (IOException | AlreadyExistsException e) {
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
		}
		
		/* Example of deleting a line from a file		 * 
		 */
		//Example course with courseCode = CMPS303
		queryArgs.clear();
		queryArgs.put(0, "CMPS303");
		try {
			int deletedCount = FileUtils.deleteFromFile(courseFilePath, queryArgs, true);
			System.out.println("Number for lines deleted: " + deletedCount);
		} catch (Exception e) {
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
		}

		//Redisplay the content of course file to confirm the changes
		List<String> courseLines = FileUtils.readFile(courseFilePath);
		for (String line : courseLines)
			System.out.println(line);

	}
}
