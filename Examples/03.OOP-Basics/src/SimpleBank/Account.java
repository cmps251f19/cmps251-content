package SimpleBank;

public class Account {
	private int id;
	private String name;
	private String type;
	private double balance;
	
	public Account (int id, String name, String type) {
		this.id = id;
		this.name = name;
		this.type = type;
		balance = 0;
	}
	
	double getBalance() {
		return balance;
	}
	
	String deposit(double amount) {
		balance += amount;
		return amount + " deposited to your acct. Your new balance is " + balance;
	}
	
	String withdraw(double amount) {
		balance -= amount;
		return amount + " withdrawn from your acct. Your new balance is " + balance;	
	}
	
	void setId(int acctId) {
		if (acctId > 0)
			id = acctId;
	}
	
	int getId() {
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
	
}
