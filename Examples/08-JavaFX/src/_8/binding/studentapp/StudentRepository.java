package _8.binding.studentapp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import org.hildan.fxgson.FxGson;
import com.google.gson.Gson;

public class StudentRepository {
	
    public static List<Student> getStudents() {
    	List<Student> students = null;
		//Use FxGson as it supports classes with properties
		Gson gson = FxGson.coreBuilder().setPrettyPrinting().create();
		String filePath = "data/students.json";
		try {
			// Read file content
			String fileContent = Files.readString(Paths.get(filePath));
			// System.out.println(fileContent);

			// Convert json text to an array of Student objects
			Student[] studentsArray = gson.fromJson(fileContent, Student[].class);
			students = Arrays.asList(studentsArray);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
        /*students.add(new Student(12, "Ali", "Faleh", "ali@example.com"));
        students.add(new Student(15, "Khadija", "Saleh", "khadija@example.com"));
        students.add(new Student(100, "Mariam", "Salem", "mariam@example.com"));
        */
        return students;
    }
    
	public static void saveStudents(Student[] students) {
		//Use FxGson as it supports classes with properties
		Gson gson = FxGson.coreBuilder().setPrettyPrinting().create();
		String filePath = "data/students.json";
		String json = gson.toJson(students);
		// Write json to a file
		try {
			Files.writeString(Paths.get(filePath), json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
