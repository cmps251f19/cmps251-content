package SimpleBank;

public class Application {

	public static void main(String[] args) {
		int x = 10;
		
		// OOP Principle - Encapsulation
		Account saraAcct = new Account(123, "Sara", "Saving" );
		//saraAcct.setId(123);
		//saraAcct.setName("Sara");
		//saraAcct.setType("Saving");
		
		String confirmationMsg = saraAcct.deposit(500);
		System.out.println(confirmationMsg);
		
		System.out.println("Welcome " + saraAcct.getName() + ". Your acct balance is " + saraAcct.getBalance());
	}

}
