// Exercises 3.12 Solution: InvoiceTest.java
// Application to test class Invoice.

public class InvoiceTest {
   public static void main(String[] args) {
      Invoice invoice1 = new Invoice("1234", "Hammer", 2, 14.95);
 
      // display invoice1
      System.out.println("Original invoice information");
      System.out.printf("Part number: %s%n", invoice1.getPartNumber());
      System.out.printf("Description: %s%n", invoice1.getPartDescription());
      System.out.printf("Quantity: %d%n", invoice1.getQuantity());
      System.out.printf("Price: %.2f%n", invoice1.getPricePerItem());
      System.out.printf("Invoice amount: %.2f%n", invoice1.getInvoiceAmount());

      // change invoice1's data
      invoice1.setPartNumber("001234");
      invoice1.setPartDescription("Yellow Hammer");
      invoice1.setQuantity(3);
      invoice1.setPricePerItem(19.49);

      // display invoice1 with new data
      System.out.printf("%nUpdated invoice information%n");
      System.out.printf("Part number: %s%n", invoice1.getPartNumber());
      System.out.printf("Description: %s%n", invoice1.getPartDescription());
      System.out.printf("Quantity: %d%n", invoice1.getQuantity());
      System.out.printf("Price: %.2f%n", invoice1.getPricePerItem());
      System.out.printf("Invoice amount: %.2f%n", invoice1.getInvoiceAmount());

      Invoice invoice2 = new Invoice("5678", "Paint Brush", -5, -9.99);
 
      // display invoice2
      System.out.printf("%nOriginal invoice information%n");
      System.out.printf("Part number: %s%n", invoice2.getPartNumber());
      System.out.printf("Description: %s%n", invoice2.getPartDescription());
      System.out.printf("Quantity: %d%n", invoice2.getQuantity());
      System.out.printf("Price: %.2f%n", invoice2.getPricePerItem());
      System.out.printf("Invoice amount: %.2f%n", invoice2.getInvoiceAmount());

      // change invoice2's data
      invoice2.setQuantity(3);
      invoice2.setPricePerItem(9.49);

      // display invoice2 with new data
      System.out.printf("%nUpdated invoice information%n");
      System.out.printf("Part number: %s%n", invoice2.getPartNumber());
      System.out.printf("Description: %s%n", invoice2.getPartDescription());
      System.out.printf("Quantity: %d%n", invoice2.getQuantity());
      System.out.printf("Price: %.2f%n", invoice2.getPricePerItem());
      System.out.printf("Invoice amount: %.2f%n", invoice2.getInvoiceAmount());
   } // end main
} // end class InvoiceTest


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
