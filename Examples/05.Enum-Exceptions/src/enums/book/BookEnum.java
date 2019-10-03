package enums.book;

//Declaring an enum type with a constructor and instance attributes and accessors for these attributes
public enum BookEnum {
	//Each enum constant in enum type BookEnum is an object of enum type BookEnum that has its own copy of instance variables.

	//declare constants of enum type 
	JAVA("Java How to Program", "2018"),
	CPP("C++ How to Program", "2017"),  
	IW3("Internet & World Wide Web How to Program", "2012"),
	VB("Visual Basic How to Program", "2014"),
	CSHARP("Visual C# How to Program", "2017");
	
	//instance attributes
	private final String title;
	private final String publicationYear; 
	
	//enum constructor
	BookEnum(String title, String copyrightYear) {
		this.title = title;
		this.publicationYear = copyrightYear;
	}

	public String getTitle() {
		return title;
	}

	public String getPublicationYear() {
		return publicationYear;
	}
}