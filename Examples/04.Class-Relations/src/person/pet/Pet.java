package person.pet;

public class Pet {
	
	String name;
	String type;
	Person owner;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public Person getOwner() {
		return owner;
	}
	
	public void setOwner(Person owner) {
		this.owner = owner;
	}
	
	public Pet(String name, String type, Person owner) {
		this.name = name;
		this.type = type;
		this.owner = owner;
	}
}