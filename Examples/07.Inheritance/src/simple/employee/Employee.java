package simple.employee;

//Total: 4pts
//1pt for abstract
public abstract class Employee {
	private String firstName;
	private String lastName;

	//1pt for constructor and attributes
	public Employee(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	//2pts for abstract method
	abstract double getPaymentAmount();
}