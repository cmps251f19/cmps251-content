package qu.bookstore;

import java.util.Scanner;

public class BookStoreUI {
	public static void main(String args[]) {
		System.out.println("**** Welcome to QU Bookstore ****\n");
		BookCatalog.addTestBooks();
		ShoppingCart shoppingCart = addItemsToShoppingCart();
		displayShoppingCart(shoppingCart);
	}

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

	public static void displayShoppingCart(ShoppingCart shoppingCart) {
		String lineText = String.format("%-6s %-40s %10s %10s %15s", "Code",
				"Description", "Price", "Qty", "Total");
		System.out.println(lineText);

		lineText = String.format("%-6s %-40s %10s %10s %15s", "----",
				"-----------", "-----", "---", "-----");
		System.out.println(lineText);

		for (CartItem cartItem : shoppingCart.getCartItems()) {
			Book book = cartItem.getBook();
			lineText = String.format("%-6s %-40s %10s %10d %15s",
					book.getCode(), book.getDescription(),
					book.getFormattedPrice(), cartItem.getQuantity(),
					cartItem.getFormattedTotal());
			System.out.println(lineText);
		}
		
		System.out.printf("%85s\n",
				"ShoppingCart total: " + shoppingCart.getFormattedTotal());
	}
}
