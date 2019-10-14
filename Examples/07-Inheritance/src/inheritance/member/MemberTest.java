package inheritance.member;

public class MemberTest {

	public static void main(String[] args) {
		Department department = new Department();

		Student student1 = new Student(123, "Fatima", "Ali", "fatima@test.edu", 90);

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

	}
}
