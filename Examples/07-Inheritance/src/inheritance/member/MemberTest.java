package inheritance.member;

import java.util.ArrayList;
import java.util.List;

public class MemberTest {

	public static void main(String[] args) {
		Department department = new Department();

		Student student1 = new Student(123, "Fatima", "Ali", "fatima@test.edu", 60, 3.5);

		department.addMember(student1);

		System.out.printf("StudentInfo: %s\n", student1);

		Instructor instructor1 = new Instructor(321, "Farida", "Saleh",
				"farida@test.edu", "CSE120", 3);

		department.addMember(instructor1);

		System.out.printf("InstructorInfo: %s\n", instructor1);

		for (Member member : department.getMembers()) {
			System.out.println(member.getClass().getName());
			System.out.println(member.toString());

			if (member instanceof Instructor)
				System.out.println("Office number: " + ((Instructor) member).getOffice());

			if (member instanceof Student)
				System.out.println("GPA: " + ((Student) member).getGpa());
		}
		
		/*
		List<Student> students = new ArrayList<>();
		students.add(new Student("Fatima", "Ali", 3.6));
		students.add(new Student("Saleh", "Ahmed", 2.5));
		
		List<Instructor> instructors = new ArrayList<>();
		instructors.add(new Instructor("Karim", "Samir", "C07-130"));
		instructors.add(new Instructor("Karima", "Samira", "C08-120"));
		
		students.forEach(s -> {
			System.out.println(s.toString());
			System.out.println(s.getGpa());
		});
		
		instructors.forEach(i -> {
			System.out.println(i.toString());
			System.out.println(i.getOffice());
		});
		*/
	}
}
