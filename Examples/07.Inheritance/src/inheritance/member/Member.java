package inheritance.member;

public abstract class Member {
	protected int id;
	private String firstName;
	private String lastName;
	private String email;

	public Member() {

	}

	public abstract boolean isSenior();
	
	public Member(int id, String firstName, String lastName, String email) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
	public Member(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}


	public String toString() {
		return "Name: " + firstName + " " + lastName + " - Email:" + email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
