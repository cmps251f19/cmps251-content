package inheritance.employee;

public class Cat extends Pet {
	public Cat(String name) {
		super(name);
	}
	
	@Override
	public String talk() {
		return String.format("Meow! My name is: %s", getName());
	}
}
