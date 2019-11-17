package _8.binding.studentapp;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public class StudentRepository {

    public static List<Student> getStudents() {
    	List<Student> students = null;
    	ObjectMapper jsonMapper = new ObjectMapper();
		String filePath = "data/students.json";
		try {
			Student[] studentsArray = jsonMapper.readValue( new File(filePath), Student[].class);
			students = Arrays.asList(studentsArray);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return students;
        /*students.add(new Student(5, "Ali", "Faleh", "ali@example.com"));
        students.add(new Student(10, "Khadija", "Saleh", "khadija@example.com"));
        students.add(new Student(15, "Mariam", "Salem", "mariam@example.com"));
        */
    }
    
	public static void saveStudents(Student[] students) {
		ObjectMapper jsonMapper = new ObjectMapper();
		String filePath = "data/students.json";
		// Write students array to a json file
		try {
			jsonMapper.writeValue(new File(filePath), students);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
