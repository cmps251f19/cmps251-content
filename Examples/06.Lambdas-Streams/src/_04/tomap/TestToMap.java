package _04.tomap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors; 

public class TestToMap {
  public static List<Person> createPeople() {
    return List.of(
	    new Person("Sara", Gender.FEMALE, 20),
	    new Person("Fatima", Gender.FEMALE, 22),
	    new Person("Farida", Gender.MALE, 20),
	    new Person("Ali", Gender.FEMALE, 32),
	    new Person("Ahmed", Gender.MALE, 32),
	    new Person("Mustapha", Gender.MALE, 2),
	    new Person("Karim", Gender.MALE, 72),
	    new Person("Karima", Gender.FEMALE, 12)
	  );
  }

  public static void main(String[] args) {
    List<Person> people = createPeople();
    
    //create a Map with name and age as key, and the person as value.
    Map<String, Integer> peopleMap = people.stream()
    							.filter(p -> p.getAge() > 20)
						        .collect(Collectors.toMap(
						                person -> person.getName(),
						                person -> person.getAge()));
    System.out.println(peopleMap);
  }
}