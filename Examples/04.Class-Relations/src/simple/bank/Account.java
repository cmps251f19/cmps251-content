package simple.bank;

/** 
*	Account class to demonstrate OOP encapsulation principle
*   @author <a href="erradi@coding.com">Erradi</a>
*/
public class Account {
	private int id;
	private String type;
	private double balance; // by default the value will be 0
	private Customer customer;
	
	public Account () {
	}
	
	public Account (int id, Customer customer, String type) {
		this.id = id;
		this.customer = customer;
		this.type = type;
	}
	
	public Account (int id, Customer customer, String type, double balance) {
		this(id, customer, type);
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

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}	
	
	public boolean equals(Account acct) {
		return ( this.id == acct.getId() && this.customer.getId() == acct.getCustomer().getId() &&
				this.type == acct.getType() && this.balance == acct.getBalance() );
	}
	
}