package tutorial4.excercise1;

public class Invoice {
   private final int itemNumber; 
   private final String itemDescription;
   private int quantity;
   private double price;

   public Invoice(int itemNumber, String itemDescription, int quantity, double price) {
      this.itemNumber = itemNumber;
      this.itemDescription = itemDescription;
	  setQuantity(quantity);
	  setPrice(price);
   }

   public int getItemNumber() {
      return itemNumber;
   } 

   public String getItemDescription() {
      return itemDescription;
   } 

   public void setQuantity(int quantity) {
      if (quantity <0) {
         throw new IllegalArgumentException("Quantity must be >= 0");
      }

      this.quantity = quantity;
   } 

   public int getQuantity() {
      return quantity;
   }

   public void setPrice(double price) {
      if (price <0.0) {
         throw new IllegalArgumentException("Price per item must be >= 0");
      }
      this.price = price;
   } 

   public double getPrice() {
      return price;
   } 

   @Override
   public String toString() {
      return String.format(
         "Item #: %-2d  Description: %-15s  Quantity: %-4d  Price: $%,6.2f", 
         getItemNumber(), getItemDescription(), 
         getQuantity(), getPrice());
   } 
}