package qu.gradebook;

public class Student {
	private int id;
	private String firstname, lastname;
	private double grade;
	
	public Student(int id, String firstname, String lastname, double grade) {
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.grade = grade;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public double getGrade() {
		return grade;
	}

	public void setGrade(double grade) {
		this.grade = grade;
	}
}