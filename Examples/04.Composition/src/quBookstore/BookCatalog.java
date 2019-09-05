package quBookstore;

import java.util.ArrayList;
import java.util.List;

public class BookCatalog {

	private static List<Book> books = new ArrayList<>();

	public static void addTestBooks() {
		if (!books.isEmpty()) {
			return;
		}
		// In a more realistic application, this code would
		// get the data for the product from a file or database
		// For now, this code stores the books in a List

		// create the Book object
		Book book = new Book("Java", "Java with Ali Baba in 21 days", 49.5);
		books.add(book);
		System.out.println("Book with code 'Java' added to the catalog");

		book = new Book("C++", "Fun journey with C++", 29.5);
		books.add(book);
		System.out.println("Book with code 'C++' added to the catalog");

		book = new Book("Math", "Scary Math with fear", 59.5);
		books.add(book);
		System.out.println("Book with code 'Math' added to the catalog\n\n");
	}

	public static Book getBook(String bookCode) {
		for (Book book : books) {
			if (book.getCode().equalsIgnoreCase(bookCode)) {
				return book;
			}
		}
		return null;
	}
}