package _9.mvapp.member;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class MemberRepository {

	private static final ObjectMapper jsonMapper = new ObjectMapper();
	  
    public static List<Member> getMembers() {
		jsonMapper.registerModule(new JavaTimeModule());
		jsonMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		
    	List<Member> members = null;
		String filePath = "data/members.json";
		try {
			Member[] membersArray = jsonMapper.readValue(new File(filePath), Member[].class);
			members = Arrays.asList(membersArray);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
        return members;
    }
    
	public static void saveMembers(Member[] members) {
		jsonMapper.registerModule(new JavaTimeModule());
		jsonMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		
		//If members is null then initialize the members array with some test data
		if (members == null) {
			members = new Member[] {
					new Student(1, "Ali", "Faleh", "ali@example.com", 2.5, LocalDate.parse("2000-01-20")),
					new Student(5, "Khadija", "Saleh", "khadija@example.com", 3.8, LocalDate.parse("2000-01-21")),
					new Student(10, "Mariam", "Salem", "mariam@example.com", 3.6, LocalDate.parse("2000-01-22")),
					new Faculty(20, "Abbes", "Ibn Firnas", "abbes@example.com", "C07-Fun Room")
			};
		}
		
		String filePath = "data/members.json";
		try {
			jsonMapper.writerWithDefaultPrettyPrinter().writeValue(new File(filePath), members);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
