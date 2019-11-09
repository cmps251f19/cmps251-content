package _8.binding.bookapp;

import java.util.ArrayList;
import java.util.List;

public class BookRespository {
	public static List<Book> getBooks() {
		List<Book> books = new ArrayList<Book>();
		
		books.add(new Book("Android How to Program", 
					"images//small/androidhtp.jpg", "images//large/androidhtp.jpg"));
		books.add(new Book("C How to Program", 
				"images//small/chtp.jpg", "images//large/chtp.jpg"));
		books.add(new Book("C++ How to Program", 
				"images//small/cpphtp.jpg", 
				"images//large/cpphtp.jpg"));
		books.add(new Book("Internet and World Wide Web How to Program", 
				"images//small/iw3htp.jpg", "images//large/iw3htp.jpg"));
		books.add(new Book("Java How to Program", 
				"images//small/jhtp.jpg", "images//large/jhtp.jpg"));
		books.add(new Book("Visual Basic How to Program", 
				"images//small/vbhtp.jpg", "images//large/vbhtp.jpg"));
		books.add(new Book("Visual C# How to Program", 
				"images//small/vcshtp.jpg", "images//large/vcshtp.jpg"));
		
		return books;
	}
}