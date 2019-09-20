package person.pet;

public class PetTest {
	public static void main(String[] args) {
		Person person1 = new Person("Ahmed", "Saleh");
		Pet cat1 = new Pet("Kitty", "cat", person1);
		Pet cat2 = new Pet("Prince", "cat", person1);
		person1.addPet(cat1);
		person1.addPet(cat2);
		Pet aPet = person1.getPet("Kitty");
		System.out.println("Kitty is a " + aPet.getType() + " owned by " +
			aPet.getOwner().getFirstName());
		System.out.println(person1.toString());
	}
}