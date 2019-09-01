package QuBank;

/** 
*	Account class to demonstrate OOP encapsulation principle
*   @author <a href="erradi@coding.com">Erradi</a>
*/

public class Account {
	private int accountNo;
	private String accountName;
	private double balance;
	
	public Account(int accountNo, String accountName, double balance)
	{
		this.accountNo = accountNo;
		this.accountName = accountName;
		this.balance = balance;
	}
	
	public Account(int accountNo, String accountName)
	{
		this.accountNo = accountNo;
		this.accountName = accountName;
		this.balance = 0;
	}
	
	public int getAccountNo() {
		return accountNo;
	}
	
	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}
	
	public String getAccountName() {
		return accountName;
	}
	
	public void setAccountName(String accountName) {
		this.accountName = accountName;
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
		return String.format("Deposit done. Your new balance is %.2f", balance);
	}
	
	public String withdraw(double amount) {
		balance -= amount;
		return String.format("Withdraw done. Your new balance is %.2f", balance);
	}

}