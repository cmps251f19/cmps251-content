// Exercise 3.14 Solution: Date.java
// Date class declaration.

public class Date {
   private int month; // 1-12
   private int day; // 1-31 based on month
   private int year; // any year
   
   // constructor: confirm proper value for month and day given the year
   public Date(int day, int month, int year) {
      // check if day in valid range
      if (day <= 0 || day > 31) {
         throw new IllegalArgumentException("day (" + day + ") out-of-range");
      }

      // check if month in valid range
      if (month <= 0 || month > 12) {
         throw new IllegalArgumentException(
            "month (" + month + ") must be 1-12");
      }

      // validate year greater than or equal to 2000
      if (year < 2000) {
         throw new IllegalArgumentException("year must be greater than or equal 2000");
      }

      this.month = month;
      this.day = day;
      this.year = year;

      System.out.printf("Date object constructor for date %s%n", this);
   } 
   
   // return a String of the form day/month/year
   public String toString() {
      return String.format("%d/%d/%d", day, month, year); 
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
