package inheritance.employee;

public abstract class Employee implements Payable
{
   private String firstName;
   private String lastName;
   private String qid;

   // three-argument constructor
   public Employee( String firstName, String lastName, String qid )
   {
	  this.firstName = firstName;
	  this.lastName = lastName;
      this.qid = qid;
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
   
   public void setQid( String qid )
   {
      this.qid = qid;
   }

   public String getQid()
   {
      return qid;
   }

   // return String representation of Employee object
   public String toString()
   {
      return String.format( "%s %s\nQatari Id: %s", 
         getFirstName(), getLastName(), getQid() );
   }

   // Note: We do not implement Payable method getPaymentAmount here so  
   // this class must be declared abstract to avoid a compilation error.
}