package inheritance.employee;

public class PayableApp2 
{
   public static void main( String args[] )
   {
	  // Payable payable2 = new SalariedEmployee("", "", "", 33);
	   
      // create payable array
      Payable payables[] = new Payable[ 5 ];
      
      // populate array with objects that implement Payable
      payables[ 0 ] = new Invoice( "01234", "Textbook", 2, 375.00 );
      payables[ 1 ] = new Invoice( "56789", "USB Disk", 3, 179.95 );
      payables[ 2 ] = new SalariedEmployee( "Ahmed", "Ali", "111-11-1111", 15000.00 );
      payables[ 3 ] = new HourlyEmployee( "Fatima", "Saleh", "222-22-2222", 160.75, 40 );
      payables[ 4 ] = new CommissionEmployee( "Samir", "Sami", "333-33-3333", 100000, .06 );

      System.out.println("Invoices and Employees processed polymorphically:\n" ); 

      // generically process each element in array payableObjects
      for ( Payable payable : payables )
      {
         // output currentPayable and its appropriate payment amount
         System.out.printf( "ObjectType: %s - PaymentAmount = %s\n", 
        		 payable.getClass().getSimpleName(),
        		 payable.amountToCurrency() ); 
         
         // or use Payable.toCurrency(payable.getPaymentAmount()) instead of payable.amountToCurrency()
         
         //If SalariedEmployee then increase the salary by 10%
         if ( payable instanceof SalariedEmployee)
         {
            // downcast Payable reference to 
            // BasePlusCommissionEmployee reference
        	 SalariedEmployee salariedEmployee = ( SalariedEmployee ) payable;

            double oldBaseSalary = salariedEmployee.getSalary();
            salariedEmployee.setSalary(oldBaseSalary * 1.1);
            System.out.printf( "New salary with 10%% increase is: QR %,.2f\n",
            		salariedEmployee.getSalary() );
         }
      } 
   } 
}