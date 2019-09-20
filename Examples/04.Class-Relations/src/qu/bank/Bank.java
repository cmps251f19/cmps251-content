package qu.bank;


import java.util.ArrayList;
import java.util.List;

public class Bank {
    private static List<Account> accounts = new ArrayList<>();
    private static int lastAccountNo = 0;
    
    public static void addTestAccounts() {
    	if (!accounts.isEmpty())
    		return;
    	
        Account aliAcount = new Account(++lastAccountNo, "Ali Faleh", "Saving", 500);
        addAccount(aliAcount);
        String msg = String.format("New Account #%d for %s. Its balance is QR%.2f", aliAcount.getId(), aliAcount.getName(), aliAcount.getBalance());
        System.out.println(msg);

        Account fatimaAcount = new Account(++lastAccountNo, "Fatima Saleh", "Current", 1000);
        addAccount(fatimaAcount);
        msg = String.format("New Account #%d for %s. Its balance is QR%.2f\n", fatimaAcount.getId(), fatimaAcount.getName(), fatimaAcount.getBalance());
        System.out.println(msg);
    }
    
    public static void addAccount(Account account) {
        accounts.add(account);
    }
    
    public static Account getAccount(int accountNo) {
        for (var account : accounts) {
            if (account.getId() == accountNo) {
                return account;
            }
        }
        return null;
    }
    
    public static double getBalance(int accountNo) {
    	Account account = getAccount(accountNo);
    	if (account != null)
    		return account.getBalance();
    	else
    		return 0;
    }
    
    public static String deposit(int accountNo, double amount) {
    	Account account = getAccount(accountNo);
    	if (account != null) 
    		return account.deposit(amount);
    	else 
    		return "Account not found";
    }
    
    public static String withdraw(int accountNo, double amount) {
    	Account account = getAccount(accountNo);
    	if (account != null) 
    		return account.withdraw(amount);
    	else 
    		return "Account not found";
    }

	public static String getFormattedBalance(int accountNo) {
    	Account account = getAccount(accountNo);
    	if (account != null)
    		return String.format("Welcome %s. Your account balance is QR%.2f\n", account.getName(), account.getBalance());
    	else 
    		return "Account not found";
	}
}
