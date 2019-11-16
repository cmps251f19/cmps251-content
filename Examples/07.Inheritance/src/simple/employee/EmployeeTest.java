package simple.employee;

import java.util.ArrayList;
import java.util.List;

//Total: 7pts
//1pt for making the implementation of the classes according the 
//given class diagram
public class EmployeeTest 
{
   public static void main( String args[] )
   {
	   Hello hello = new Hello();
	   System.out.println(hello.getClass());
	   System.out.println(hello.toString());
		
	  //2pts for the list
      List<Employee> employees = new ArrayList<>();
      
      //2pts for initialization
      // populate array with objects that implement Payable
      employees.add(new SalariedEmployee("Ahmed", "Ali",  15000 ));
      employees.add(new HourlyEmployee("Fatima", "Saleh", 200, 160 ));
      employees.add(new HourlyEmployee("Samir", "Sami", 150, 120 )); 

      //2pts for display
      // Generically process each element in Employees List
      for ( Employee employee : employees )
      {
    	 System.out.println(employee);
         System.out.printf( "EmployeeType: %s ; EmplyeeName: %s %s; PaymentAmount: QR%.2f\n", 
        		 employee.getClass().getSimpleName(),
        		 employee.getFirstName(), employee.getLastName(),
        		 employee.getPaymentAmount() ); 
      }
   }
}