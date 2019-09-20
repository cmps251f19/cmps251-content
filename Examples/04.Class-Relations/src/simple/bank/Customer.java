package simple.bank;

import java.util.ArrayList;
import java.util.List;

public class Customer {
	private int id;
	private String firstname, lastname, email;
	private Address address;
	private List<Account> accounts;

	
	public Account getAccount(int acctId) {
		for(var account : accounts) {
			if (account.getId() == acctId)
				return account;
		}
		return null;
	}

	public void addAccount(Account account) {
		accounts.add(account);
		/*
		int index = 0;
		for (index = 0; index < SIZE; index++) {
			if (accounts[index] == null)
				break;
		}
		if (index < SIZE)
			accounts[index] = account;
		else
			System.out.println("Max accounts you can add is " + SIZE);
		*/
	}

	public double getTotalBalance() {
		double totalBalance = 0;
		for (var acct : accounts) {
			if (acct != null)
				totalBalance += acct.getBalance();
		}
		return totalBalance;
	}
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	public Customer(int id, String firstname, String lastname, String email) {
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		accounts = new ArrayList<>();
	}
	
	public Customer(int id, String firstname, String lastname, String email, Address address) {
		this(id, firstname, lastname, email);
		this.address = address;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public void removeAccount(Account account) {
		accounts.remove(account);
	}

	public int getAccountsCount() {
		return accounts.size();
	}
}
