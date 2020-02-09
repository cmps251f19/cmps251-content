package inheritance.employee;

public abstract class Employee implements Payable
{
   private String firstName;
   private String lastName;
   private String employeeId;

   // three-argument constructor
   public Employee( String firstName, String lastName, String qid )
   {
	  this.firstName = firstName;
	  this.lastName = lastName;
      this.employeeId = qid;
   }
   
   public void setFirstName( String firstName )
   {
      this.firstName = firstName;
   }
   
   public String getFirstName()
   {
      return firstName;
   }
   
   public void setLastName( String lastName )
   {
      this.lastName = lastName;
   }
   
   public String getLastName()
   {
      return lastName;
   }
   
   public void setEmployeeId( String qid )
   {
      this.employeeId = qid;
   }

   public String getEmplyeeId()
   {
      return employeeId;
   }

   // return String representation of Employee object
   public String toString()
   {
      return String.format( "%s %s\nQatari Id: %s", 
         getFirstName(), getLastName(), getEmplyeeId() );
   }

   // Note: We do not implement Payable method getPaymentAmount here so  
   // this class must be declared abstract to avoid a compilation error.
}