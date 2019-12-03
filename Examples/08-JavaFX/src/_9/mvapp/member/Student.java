package _9.mvapp.member;

import java.time.LocalDate;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;

public class Student extends Member {
	private final DoubleProperty gpa;
	private ObjectProperty<LocalDate> dob;
	
	public DoubleProperty gpaProperty() { return gpa; }
	
	public ObjectProperty<LocalDate> dobProperty() { return dob; }
	
    public Student() {
   	 	this(0, "", "", "", 0, null);
    }
    
	public Student(int id, String firstName, String lastName, String email, double gpa, LocalDate dob) {
		super(id, firstName, lastName, email);
		this.gpa = new SimpleDoubleProperty(gpa);
		if (dob != null)
			this.dob = new SimpleObjectProperty<LocalDate>(dob);
		else
			this.dob = new SimpleObjectProperty<LocalDate>();
	}
	
	public double getGpa() {
		return gpa.get();
	}
	
	public void setGpa(double gpa) {
		this.gpa.set(gpa);
	}
	
	public LocalDate getDob() {
		return dob.get();
	}
	public void setDob(LocalDate dob) {
		this.dob.set(dob);
	}
}
