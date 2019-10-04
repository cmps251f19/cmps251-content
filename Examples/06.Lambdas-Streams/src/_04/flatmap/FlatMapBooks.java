package _04.flatmap;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMapBooks {
  public static void main(String[] args) {
      Student student1 = new Student("Abbas ibn Firnas");
      student1.addBook("Java 13 in Action, 1st Edition");
      student1.addBook("Lambdas and Streams in Action, 4th Edition");
      student1.addBook("Effective Java, 2nd Edition");

      Student student2 = new Student("Juha Dahak");
      student2.addBook("Java 13 in Action, 1st Edition");
      student2.addBook("Effective Java, 2nd Edition");

      List<Student> students = List.of(student1, student2);

      // Using .map retuns a List of Lists
      List<List<String>> bookLists =
              students.stream()
                      .map(s -> s.getBooks())
                      .distinct()
                      .collect(Collectors.toList());

      bookLists.forEach(System.out::println);
      
      // Using .flatMap to get one consolidated list
      List<String> books =
              students.stream()
                      .flatMap(s -> s.getBooks().stream())
                      .distinct()
                      .collect(Collectors.toList());

      books.forEach(System.out::println);
  }
}