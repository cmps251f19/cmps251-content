package qu.bookstore;

import java.text.NumberFormat;
import java.util.Currency;
import java.util.Scanner;

public class BookStoreUI {
	public static void main(String args[]) {
		System.out.println("**** Welcome to QU Bookstore ****\n");
		BookCatalog.addTestBooks();
		ShoppingCart shoppingCart = new ShoppingCart();
		shoppingCart.addItem(new CartItem(BookCatalog.getBook("Java"), 2));
		shoppingCart.addItem(new CartItem(BookCatalog.getBook("C++"), 3));
		
		// Or uncomment this line to allow the user to enter the books and quantities they want to buy
		//ShoppingCart shoppingCart = addItemsToShoppingCart();
		displayShoppingCart(shoppingCart);
	}

	public static void displayShoppingCart(ShoppingCart shoppingCart) {
		String lineText = String.format("%-6s %-40s %10s %10s %15s", "Code",
				"Description", "Price", "Qty", "Total");
		System.out.println(lineText);

		lineText = String.format("%-6s %-40s %10s %10s %15s", "----",
				"-----------", "-----", "---", "-----");
		System.out.println(lineText);

		// This currencyFormatter enable displaying a number in currency format. E.g., 1000 will be displayed QAR1,000
		NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();
		currencyFormatter.setCurrency(Currency.getInstance("QAR"));
		
		for (CartItem cartItem : shoppingCart.getCartItems()) {
			Book book = cartItem.getBook();
			lineText = String.format("%-6s %-40s %10s %10d %15s",
					book.getCode(), book.getDescription(),
					currencyFormatter.format(book.getPrice()), 
					cartItem.getQuantity(),
					currencyFormatter.format(cartItem.getTotal()) );
			System.out.println(lineText);
		}
		
		System.out.printf("%85s\n", "ShoppingCart total: " + currencyFormatter.format(shoppingCart.getTotal()));
	}
	
	/*	
	public static ShoppingCart addItemsToShoppingCart() {
		ShoppingCart shoppingCart = new ShoppingCart();
		Scanner scanner = new Scanner(System.in);
		String choice = "y";

		while (choice.equalsIgnoreCase("y")) {
			// get the input from the user
			String productCode = DataEntryUtils.getString(scanner,
					"Enter book code to order: ");
			
			int quantity = DataEntryUtils.getInt(scanner,
					"Enter quantity:     ", 0, 1000);

			Book book = BookCatalog.getBook(productCode);

			if (book != null) {
				shoppingCart.addItem(new CartItem(book, quantity));
			} else {
				System.out.println("Book not found.");
			}

			// see if the user wants to continue
			choice = DataEntryUtils.getString(scanner,
					"Another line item? (y/n): ");
			System.out.println();
		}

		return shoppingCart;
	}
	*/
}
