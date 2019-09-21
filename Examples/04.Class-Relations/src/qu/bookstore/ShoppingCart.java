package qu.bookstore;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
	// the instance variable
	private List<CartItem> cartItems;

	// the constructor
	public ShoppingCart() {
		cartItems = new ArrayList<>();
	}

	// a method that adds a cart item
	public void addItem(CartItem cartItem) {
		this.cartItems.add(cartItem);
	}

	// the get accessor for the cart item collection
	public List<CartItem> getCartItems() {
		return cartItems;
	}

	// a method that gets the shopping cart total
	public double getTotal() {
		double shoppingCartTotal = 0;
		for (CartItem cartItem : this.cartItems) {
			shoppingCartTotal += cartItem.getTotal();
		}
		return shoppingCartTotal;
	}
}
