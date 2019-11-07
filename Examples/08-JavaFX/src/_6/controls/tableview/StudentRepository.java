package _6.controls.tableview;

import java.util.ArrayList;
import java.util.List;

public class StudentRepository {
	
    public static List<Student> getStudents() {
    	List<Student> students = new ArrayList<>(); 
        students.add(new Student(12, "Ali", "Faleh", "ali@example.com"));
        students.add(new Student(15, "Khadija", "Saleh", "khadija@example.com"));
        students.add(new Student(100, "Mariam", "Salem", "mariam@example.com"));
        return students;
    }
}
