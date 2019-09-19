// Exercises 3.12 Solution: Invoice.java
// Invoice class.

public class Invoice {
   private String partNumber; 
   private String partDescription;
   private int quantity;
   private double pricePerItem;

   // constructor
   public Invoice(String partNumber, String partDescription, int quantity, 
      double pricePerItem) {
      this.partNumber = partNumber;
      this.partDescription = partDescription;

      if (quantity > 0) { // determine whether count is positive
         this.quantity = quantity; // valid count assigned to quantity
      }

      if (pricePerItem > 0.0) { // determine whether price is positive
         this.pricePerItem = pricePerItem; // valid price assigned to pricePerItem
      }
   } 

   // set part number
   public void setPartNumber(String partNumber) {
      this.partNumber = partNumber;  
   } 

   // get part number
   public String getPartNumber() {
      return partNumber;
   }

   // set part description
   public void setPartDescription(String partDescription) {
      this.partDescription = partDescription;
   } 

   // get part description
   public String getPartDescription() {
      return partDescription;
   } 

   // set quantity
   public void setQuantity(int quantity)
   {
      if (quantity > 0) { // determine whether count is positive
         this.quantity = quantity; // valid count assigned to quantity
      }

      if (quantity <= 0) { // determine whether count is zero or negative
         this.quantity = 0; // invalid count; quantity set to 0
      }
   } 

   // get quantity
   public int getQuantity() {
      return quantity;
   }

   // set price per item
   public void setPricePerItem(double pricePerItem) {
      if (pricePerItem > 0.0) { // determine whether price is positive
         this.pricePerItem = pricePerItem; // valid price assigned to pricePerItem
      }

      if (pricePerItem <= 0.0) { // determine whether price is zero or negative
         this.pricePerItem = 0.0; // invalid price; pricePerItem set to 0.0
      }
   } 

   // get price per item
   public double getPricePerItem() {
      return pricePerItem;
   } 

   // calculates and returns the invoice amount
   public double getInvoiceAmount() {
      return getQuantity() * getPricePerItem(); // calculate total cost
   } 
} // end class Invoice


/**************************************************************************
 * (C) Copyright 1992-2018 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/
