package _9.mvapp.member;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public class MemberRepository {

	private static final ObjectMapper jsonMapper = new ObjectMapper();
	  
    public static List<Member> getStudents() {
    	List<Member> students = null;
		String filePath = "data/students.json";
		try {
			Member[] studentsArray = jsonMapper.readValue(new File(filePath), Member[].class);
			students = Arrays.asList(studentsArray);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
        return students;
    }
    
	public static void saveMembers(Member[] members) {
		/*Member[] members = {
				new Student(1, "Ali", "Faleh", "ali@example.com", 2.5),
				new Student(5, "Khadija", "Saleh", "khadija@example.com", 3.8),
				new Student(10, "Mariam", "Salem", "mariam@example.com", 3.6),
				new Faculty(20, "Abbes", "Ibn Firnas", "abbes@example.com", "C07-Fun Room")
		};*/
		String filePath = "data/students.json";
		try {
			jsonMapper.writerWithDefaultPrettyPrinter().writeValue(new File(filePath), members);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
