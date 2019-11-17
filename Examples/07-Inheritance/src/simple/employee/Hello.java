package simple.employee;

public class Hello {
	@Override
	public String toString() {
		return super.toString() + String.format("Hello from %s class", getClass().getSimpleName());
	}
}
