// Exercise 3.13 Solution: EmployeeTest.java
// Application to test class Employee.

public class EmployeeTest {
   public static void main(String[] args) {
      Employee employee1 = new Employee("Bob", "Jones", 2875.00);
      Employee employee2 = new Employee("Susan", "Baker", 3150.75);

      // display employees
      System.out.printf("Employee 1: %s %s; Yearly Salary: %.2f%n", 
         employee1.getFirstName(), employee1.getLastName(),
         12 * employee1.getMonthlySalary());
      System.out.printf("Employee 2: %s %s; Yearly Salary: %.2f%n", 
         employee2.getFirstName(), employee2.getLastName(),
         12 * employee2.getMonthlySalary());

      // increase employee salaries by 10%
      System.out.printf("%nIncreasing employee salaries by 10%%%n");
      employee1.setMonthlySalary(employee1.getMonthlySalary() * 1.10);
      employee2.setMonthlySalary(employee2.getMonthlySalary() * 1.10);

      // display employees with new yearly salary
      System.out.printf("Employee 1: %s %s; Yearly Salary: %.2f%n", 
         employee1.getFirstName(), employee1.getLastName(),
         12 * employee1.getMonthlySalary());
      System.out.printf("Employee 2: %s %s; Yearly Salary: %.2f%n", 
         employee2.getFirstName(), employee2.getLastName(),
         12 * employee2.getMonthlySalary());
   } // end main
} // end class EmployeeTest


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
