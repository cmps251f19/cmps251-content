package enums.book;

public class BookEnumTest {
	public static void main(String[] args) {
		System.out.println("All books :");

		// print all books in enum Book
		// For every enum the compiler generates the static method values which returns an array of the enum's constants
		// When an enum constant is converted to a String, the constantís identifier is used as the String representation 
		// (e.g., Java for the first enum constant).
		for (BookEnum book : BookEnum.values()) {
			System.out.printf("%-10s%-45s%s%n", book, book.getTitle(), book.getPublicationYear());
		}
	}
}
