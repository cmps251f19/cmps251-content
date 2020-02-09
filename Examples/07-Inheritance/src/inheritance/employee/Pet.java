package inheritance.employee;

public abstract class Pet {
	String name;
	
	public Pet (String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public abstract String talk();
}
