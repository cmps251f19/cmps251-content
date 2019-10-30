package _6.controls.combobox;

import java.util.List;

//This is part of the App Model
public class CollegeRespository {
	
  public static List<String> getColleges() {
	 return List.of(
				"College of Arts and Sciences",
				"College of Business and Economics",
				"College of Education",
				"College of Engineering",
				"College of Health Sciences",
				"College of Law",
				"College of Medicine",
				"College of Pharmacy",
				"College of Sharia and Islamic Studies");
  } 
}