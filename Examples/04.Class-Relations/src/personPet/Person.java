package personPet;

import java.util.ArrayList;
import java.util.List;

public class Person {
	private String firstName;
	private String lastName;
	private List<Pet> pets = new ArrayList<>();

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
	
	public Person(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
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
	
	public String toString()
	{
		String toString = firstName + " has the following pets:\n";
		for(Pet pet : pets)
			toString += pet.getName() + "\n";
		return toString;
	}
}
