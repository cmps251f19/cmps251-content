package clinic.pets;

public class PetTest {
	public static void main(String[] args) {
		Customer customer1 = new Customer("Farida", "Saleh", "+974-5588-9900");
		Pet cat1 = new Pet("Kitty", "Cat", customer1);
		Pet cat2 = new Pet("Prince", "Cat", customer1);
		customer1.addPet(cat1);
		customer1.addPet(cat2);
		
		Pet aPet = customer1.getPet("Kitty");
		System.out.printf("%s is %s a owned by %s \n", 
				aPet.getName(), aPet.getType(),
				aPet.getOwner().getFirstName());
		
		System.out.println(customer1.toString());
	}
}