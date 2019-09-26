package clinic.pets;

import java.util.ArrayList;
import java.util.List;

public class Customer {
	private String firstName;
	private String lastName;
	private String mobile;
	private List<Pet> pets;
	
	public Customer(String firstName, String lastName, String mobile) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobile = mobile;
		pets = new ArrayList<>();
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Pet getPet(String petName) {
		for(Pet pet : pets)
		{
			if (pet.getName().equalsIgnoreCase(petName))
				return pet;
		}		
		return null;
	}

	public void addPet(Pet pet) {
		pets.add(pet);
	}
	
	public List<Pet> getPets() {
		return pets;
	}

	public String toString()
	{
		String toString = String.format("%s %s has the following pets:\n", firstName, lastName);
		for(Pet pet : pets)
			toString += String.format("%s (%s)\n", pet.getName(), pet.getType());
		return toString;
	}
}
