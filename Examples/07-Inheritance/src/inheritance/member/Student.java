package inheritance.member;

public class Student extends Member {
	private double gpa;
	private int totalCreditHours;

	public Student(int id, String firstName, String lastName, String email, int totalCreditHours) {
		super(id, firstName, lastName, email);
		this.totalCreditHours = totalCreditHours;
	}
	
	public Student() {
	}
	
	public boolean isSenior() {
		if(totalCreditHours > 80)
			return true;
		else
			return false;
	}
	
	public int getTotalCreditHours() {
		return totalCreditHours;
	}

	public void setTotalCreditHours(int totalCreditHours) {
		this.totalCreditHours = totalCreditHours;
	}

	public double getGpa() {
		return gpa;
	}
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	
	
}
