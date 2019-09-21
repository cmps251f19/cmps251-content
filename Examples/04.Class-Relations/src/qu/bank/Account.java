package qu.bank;

public class Account {
	private int id;
	private String name;
	private String type;
	private double balance;

	public Account(int id, String name, String type) {
		// Call the constructor below to avoid code repetition
		this(id, name, type, 0);
		/* 
		this.id = id;
	    this.name = name;
		this.type = type;
		balance = 0;
		*/
	}

	public Account(int id, String name, String type, double balance) {
		this.id = id;
		this.name = name;
		this.type = type;
		deposit(balance);
	}

	public double getBalance() {
		return balance;
	}

	public String deposit(double amount) {
		balance += amount;
		return String.format("%.2f deposited to your account. Your new balance is %.2f", amount, balance);
	}

	public String withdraw(double amount) {
		balance -= amount;
		return String.format("%.2f withdrawn from account acct. Your new balance is %.2f", amount, balance);
	}

	public void setId(int id) {
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
}