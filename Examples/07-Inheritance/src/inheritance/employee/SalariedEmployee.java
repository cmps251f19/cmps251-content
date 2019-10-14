package inheritance.employee;

public class SalariedEmployee extends Employee 
{
   private double monthlySalary;

   // four-argument constructor
   public SalariedEmployee( String first, String last, String ssn, 
      double salary )
   {
      super( first, last, ssn ); // pass to Employee constructor
      setSalary( salary ); // validate and store salary
   } // end four-argument SalariedEmployee constructor

   // set salary
   public void setSalary( double salary )
   {
      monthlySalary = salary < 0.0 ? 0.0 : salary;
   } // end method setWeeklySalary

   // return salary
   public double getSalary()
   {
      return monthlySalary;
   } // end method getWeeklySalary

   // calculate earnings; implement interface Payable method that was
   // abstract in superclass Employee
   public double getPaymentAmount()
   {
      return getSalary();
   }

   // return String representation of SalariedEmployee object
   public String toString()
   {
      return String.format( "salaried employee: %s\n%s: $%,.2f", 
         super.toString(), "weekly salary", getSalary() );
   }
}