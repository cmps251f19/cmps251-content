// Exercise 3.13 Solution: Employee.java
// Employee class.

public class Employee {
   private String firstName;
   private String lastName;
   private double monthlySalary; 

   // constructor 
   public Employee(String firstName, String lastName, double monthlySalary) {
      this.firstName = firstName;
      this.lastName = lastName;
     
      if (monthlySalary >= 0.0) { // determine whether salary is positive
         this.monthlySalary = monthlySalary; 
      }
   } 

   // set Employee's first name
   public void setFirstName(String firstName) {
      this.firstName = firstName;
   } 

   // get Employee's first name
   public String getFirstName() {
      return firstName;
   } 

   // set Employee's last name
   public void setLastName(String lastName) {
      this.lastName = lastName;
   } 

   // get Employee's last name
   public String getLastName() {
      return lastName;
   } 

   // set Employee's monthly salary
   public void setMonthlySalary(double monthlySalary) {
      if (monthlySalary >= 0.0) { // determine whether salary is positive
         this.monthlySalary = monthlySalary;
      }
   } 

   // get Employee's monthly salary
   public double getMonthlySalary() {
      return monthlySalary;
   } 
} // end class Employee


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
