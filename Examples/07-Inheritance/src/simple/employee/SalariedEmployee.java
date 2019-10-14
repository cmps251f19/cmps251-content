package simple.employee;

//Total: 4pts

//1pt for extends
public class SalariedEmployee extends Employee 
{
   private double salary;

   //Total: 2pts for constructor and attribute
   public SalariedEmployee( String firstName, String lastName, double salary )
   {
      super( firstName, lastName );
      setSalary( salary ); 
   }
   
   public void setSalary( double salary )
   {
      this.salary = salary;
   }

   //1pt
   public double getPaymentAmount()
   {
      return salary;
   }
}
