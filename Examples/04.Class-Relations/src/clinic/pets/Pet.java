package clinic.pets;

public class Pet {
	private String name;
	private String type;
	private Customer owner;
	
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
	
	public Customer getOwner() {
		return owner;
	}
	
	public void setOwner(Customer owner) {
		this.owner = owner;
	}
	
	public Pet(String name, String type, Customer owner) {
		this.name = name;
		this.type = type;
		this.owner = owner;
	}
}