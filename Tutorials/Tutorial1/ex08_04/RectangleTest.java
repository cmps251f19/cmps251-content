// Exercise 8.4 Solution: RectangleTest.java
// Program tests class Rectangle.
import java.util.Scanner;

public class RectangleTest {
   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);      
      Rectangle rectangle = new Rectangle();
      
      int choice = getMenuChoice();
      
      while (choice != 3) {
         try {
            switch (choice) {
               case 1:
                  System.out.print("Enter length: ");
                  rectangle.setLength(input.nextDouble());
                  break;            
               case 2:
                  System.out.print ("Enter width: ");
                  rectangle.setWidth(input.nextDouble());
                  break;
            } 
            
            System.out.println (rectangle.toString());
         }
         catch (IllegalArgumentException e) {
            System.out.printf("length and width must be 0.0-20.0%n%n");
         } 

         choice = getMenuChoice();
      } 
   }
   
   // prints a menu and returns a value corresponding to the menu choice
   private static int getMenuChoice() {
      Scanner input = new Scanner(System.in);
      
      System.out.printf("%n1. Set Length%n");
      System.out.println("2. Set Width");
      System.out.println("3. Exit");
      System.out.print("Choice: ");
      
      return input.nextInt();
   } 
}


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
