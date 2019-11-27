package memberapp;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class Student extends Member {
	private final DoubleProperty gpa;
	
	public DoubleProperty gpaProperty() { return gpa; }
	
    public Student() {
   	 	this(0, "", "", "", 0);
    }
    
	public Student(int id, String firstName, String lastName, String email, double gpa) {
		super(id, firstName, lastName, email);
		this.gpa = new SimpleDoubleProperty(gpa);
	}
	
	public double getGpa() {
		return gpa.get();
	}
	
	public void setGpa(double gpa) {
		this.gpa.set(gpa);
	}
}
