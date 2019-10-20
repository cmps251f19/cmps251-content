package inheritance.employee;

public class SalariedEmployee extends Employee 
{
   private double monthlySalary;

   public SalariedEmployee( String first, String last, String ssn, 
      double salary )
   {
      super( first, last, ssn ); 
      setSalary( salary );
   } 

   public void setSalary( double salary )
   {
      monthlySalary = salary < 0.0 ? 0.0 : salary;
   } 

   public double getSalary()
   {
      return monthlySalary;
   } 

   // Implement interface Payable method that was
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