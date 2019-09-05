package quBank;
import java.util.Scanner;

public class BankUI {
	public static void main(String[] args) {
		Bank.addTestAccounts();
		
		int accountNo, choice;
		double amount;
		String confirmationMessage;
		Scanner input = new Scanner(System.in);

		do {
			System.out.println("1. Get Balance");
			System.out.println("2. Deposit");
			System.out.println("3. Withdraw");
			System.out.print("Please enter your choise (-1 to exit): ");
			choice = input.nextInt();

			if (choice < 0) 
				break;

			System.out.print("Enter the AccountNo: ");
			accountNo = input.nextInt();

			switch (choice) {
			case 1:
				System.out.println(Bank.getFormattedBalance(accountNo));
				break;
				
			case 2:
				System.out.print("Enter the amount to deposit: ");
				amount = input.nextDouble();
				confirmationMessage = Bank.deposit(accountNo, amount);
				System.out.println(confirmationMessage + "\n");
				break;
				
			case 3:
				System.out.print("Enter the amount to withdraw: ");
				amount = input.nextDouble();
				confirmationMessage = Bank.withdraw(accountNo, amount);
				System.out.println(confirmationMessage + "\n");
				break;
			}
			
		} while(choice > 0);
		
		input.close(); 
	}
}