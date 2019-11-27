package memberapp;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

//Instructing the json library to add @type to each object when saving
@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, 
	include=JsonTypeInfo.As.PROPERTY, property="@type")
@JsonSubTypes({ 
	  @Type(value = Student.class, name = "Student"),
	  @Type(value = Faculty.class, name = "Faculty")
}) 

public abstract class Member {
    private final IntegerProperty id;
    private final StringProperty firstName;
    private final StringProperty lastName;
    private final StringProperty email;

    public Member() {
    	 this(0, "", "", "");
    }
    
    public Member(int id, String firstName, String lastName, String email) {
  		this.id = new SimpleIntegerProperty(id);
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        this.email = new SimpleStringProperty(email);
    }
    
    /*
     * Property getter method consists of the property name followed 
     * by the word “Property”
    */
    public IntegerProperty idProperty() { return id; }
    public StringProperty firstNameProperty() { return firstName; }
    public StringProperty lastNameProperty() { return lastName; }
    public StringProperty emailProperty() { return email; }

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