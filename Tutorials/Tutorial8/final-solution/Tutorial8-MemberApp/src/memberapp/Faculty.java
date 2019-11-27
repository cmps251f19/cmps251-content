package memberapp;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Faculty extends Member {
	private final StringProperty office;
	
	public StringProperty officeProperty() { return office; }
	
    public Faculty() {
   	 	this(0, "", "", "", "");
    }
    
	public Faculty(int id, String firstName, String lastName, String email, String office) {
		super(id, firstName, lastName, email);
		this.office = new SimpleStringProperty(office);
	}
	
	public String getOffice() {
		return office.get();
	}
	
	public void setOffice(String office) {
		this.office.set(office);
	}
}
