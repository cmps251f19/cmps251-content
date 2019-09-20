package simple.bank;
public class App {
	public static void main(String[] args) {
		// Creating the object and initializing it using a constructor
		// It took one line of code to make a properly constructed account. 
		// It would not be possible for a programmer to build an account and forget to assign a id, name or balance.
		Account saraAcct = new Account(123, "Sara", "Saving", 5000);
		Account saraAcct2 = new Account(123, "Sara", "Saving", 5000);
		
		// Compare references
		if (saraAcct == saraAcct2) {
			System.out.println("Two objects have the same reference");
		} else {
			System.out.println("Each object has its own reference");
		}
		
		// Compare values
		if (saraAcct.equals(saraAcct2)) {
			System.out.println("Two objects are equal");
		} else {
			System.out.println("Two objects are NOT equal");
		}
		
		/* 
		// Creating the object without using a constructor
		// It took 5 lines of code to make a properly constructed account. 
		// It would be possible for a programmer to build a person and forget to assign an id or name or type.
		Account saraAcct;
		saraAcct = new Account();
		saraAcct.setId(123);
		saraAcct.setName("Sara");
		saraAcct.setType("Saving");
		*/
		
		String confirmationMsg = saraAcct.deposit(500);
		System.out.println(confirmationMsg);
		
		System.out.println("Welcome " + saraAcct.getName() + ". Your acct balance is " + saraAcct.getBalance());
	}
}