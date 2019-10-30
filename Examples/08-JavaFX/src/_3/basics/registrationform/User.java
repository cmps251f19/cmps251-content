package _3.basics.registrationform;

public class User {
	String name, email, password;
	
	public User(String name, String email, String password) {

		this.name = name;
		this.email = email;
		this.password = password;
	}
	
	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return String.format("Name: %s | Email: %s | Password: %s", getName(), getEmail(), getPassword());
	}
	
}
