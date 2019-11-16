package _8.binding.firstexample;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Friend {
	private StringProperty name;
	private IntegerProperty age;
	
	public StringProperty nameProperty() {return name;};
	public IntegerProperty ageProperty() {return age; };
	
	public Friend(String name, int age) {
		this.name = new SimpleStringProperty(name);
		this.age = new SimpleIntegerProperty(age);
	}

	public String getName() {
		return name.get();
	}

	public int getAge() {
		return age.get();
	}

	public void setName(String name) {
		this.name.set(name);
	}

	public void setAge(int age) {
		this.age.set(age);
	}
	
	@Override
	public String toString() {
		return String.format("Name: %s - Age: %d", getName(), getAge());
	}
}