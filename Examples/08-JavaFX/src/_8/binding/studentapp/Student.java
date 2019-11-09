package _8.binding.studentapp;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Student {
    private final SimpleIntegerProperty id;
    private final SimpleStringProperty firstName;
    private final SimpleStringProperty lastName;
    private final SimpleStringProperty email;

    public Student() {
    	 this(0, "", "", "");
    }
    
    public Student(int id, String firstName, String lastName, String email) {
  		this.id = new SimpleIntegerProperty();
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        this.email = new SimpleStringProperty(email);
    }
    
    /*
     * Property getter method consists of the property name followed 
     * by the word “Property”
    */
    public SimpleIntegerProperty idProperty() { return id; }
    public SimpleStringProperty firstNameProperty() { return firstName; }
    public SimpleStringProperty lastNameProperty() { return lastName; }
    public SimpleStringProperty emailProperty() { return email; }

    public int getId() {
        return this.id.get();
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getFirstName() {
        return this.firstName.get();
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public String getLastName() {
        return this.lastName.get();
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public String getEmail() {
        return this.email.get();
    }

    public void setEmail(String email) {
        this.email.set(email);
    }
    
    @Override
    public String toString() {
    	return String.format("%d - %s %s (%s)", getId(), getFirstName(), getLastName(), getEmail());
    }
}