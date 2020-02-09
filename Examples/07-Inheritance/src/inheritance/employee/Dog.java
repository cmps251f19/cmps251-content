package inheritance.employee;

public class Dog extends Pet {
	public Dog(String name) {
		super(name);
	}
	
	@Override
	public String talk() {
		return String.format("Arf! My name is: %s", getName());
	}
}
