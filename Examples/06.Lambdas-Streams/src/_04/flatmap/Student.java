package _04.flatmap;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private List<String> books;

    public void addBook(String book) {
        if (this.books == null) {
            this.books = new ArrayList<>();
        }
        this.books.add(book);
    }

	public Student(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public List<String> getBooks() {
		return books;
	}
}