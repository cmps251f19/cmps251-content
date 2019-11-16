package inheritance.member;

public class Instructor extends Member {
	private String office;
	int yearsExperience;
	
	public int getYearsExperience() {
		return yearsExperience;
	}
	public void setYearsExperience(int yearsExperience) {
		this.yearsExperience = yearsExperience;
	}
	
	public boolean isSenior()
	{
		if (yearsExperience > 6)
			return true;
		else
			return false;
	}
	
	public String getOffice() {
		return office;
		
	}
	public void setOffice(String office) {
		this.office = office;
	}

	//super(); -- this is call is not really needed. It will be called
	//automatically if NO super constructor is called.
	public Instructor() {
		//The superclass default constructor will be implicitly called 
	}
	
	public Instructor(String firstName, String lastName, String office) {
		super(firstName, lastName); 
		this.office = office;
	}
	
	public Instructor(int id, String firstName, String lastName, 
					String email, String office, int yearsExperience) {
		//Explicit call to superclass constructor
		super(id, firstName, lastName, email); 
		//super.toString();
		this.office = office;
		this.yearsExperience = yearsExperience;
	}
	
	//Returns a String representing an object. 
	//Called implicitly whenever an object must be converted to a String representation.
	@Override
	public String toString() {

		//return "Name: " + getLastName() + " " + getFirstName() + " - Email:" + getEmail() + " - Office: " + office;
		return super.toString() + " - Office: " + office;
	}
}
