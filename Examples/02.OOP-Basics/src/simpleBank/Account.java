package simpleBank;

/** 
*	Account class to demonstrate OOP encapsulation principle
*   @author <a href="erradi@coding.com">Erradi</a>
*/
public class Account {
	// OOP Principle of Encapsulation: all attributes are private 
	private int id;
	private String name;
	private String type;
	private double balance;
	
	public Account () {
	}
	
	public Account (int id, String name, String type) {
		this.id = id;
		this.name = name;
		this.type = type;
		//balance = 0;
	}
	
	public Account (int id, String name, String type, double balance) {
		this.id = id;
		this.name = name;
		this.type = type;
		deposit(balance);
	}

	public double getBalance() {
		return balance;
	}
	
	/**
	 * A method to deposit money in the account. 
	 * @param amount
	 *		The amount to deposit.
	 * @return
	 * 		A deposit confirmation message. 
	*/
	public String deposit(double amount) {
		balance += amount;
		return String.format("%.2f deposited to your account. Your new balance is %.2f", amount, balance);
	}

	public String withdraw(double amount) {
		balance -= amount;
		return String.format("%.2f withdrawn from account acct. Your new balance is %.2f", amount, balance);
	}
	
	public void setId(int id) {
		if (id > 0)
			this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}	
	
	public boolean equals(Account acct) {
		return ( this.id == acct.getId() && this.name == acct.getName() &&
				this.type == acct.getType() && this.balance == acct.getBalance() );
	}
	
}