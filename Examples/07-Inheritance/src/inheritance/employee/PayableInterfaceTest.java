package inheritance.employee;

public class PayableInterfaceTest 
{
   public static void main( String args[] )
   {
      // create payable array
      Payable payableObjects[] = new Payable[ 5 ];
      
      // populate array with objects that implement Payable
      payableObjects[ 0 ] = new Invoice( "01234", "Textbook", 2, 375.00 );
      payableObjects[ 1 ] = new Invoice( "56789", "USB Disk", 4, 179.95 );
      payableObjects[ 2 ] = 
         new SalariedEmployee( "Ahmed", "Ali", "111-11-1111", 15000.00 );
      payableObjects[ 3 ] = 
         new HourlyEmployee( "Fatima", "Saleh", "222-22-2222", 160.75, 40 );
      payableObjects[ 4 ] = 
         new CommissionEmployee( 
         "Samir", "Sami", "333-33-3333", 10000, .06 );

      System.out.println( 
         "Invoices and Employees processed polymorphically:\n" ); 

      // generically process each element in array payableObjects
      for ( Payable currentPayable : payableObjects )
      {
         // output currentPayable and its appropriate payment amount
         System.out.printf( "ObjectType: %s - PaymentAmount = QR%.2f\n", 
        		 currentPayable.getClass().getSimpleName(),
        		 currentPayable.getPaymentAmount() ); 
            
         if ( currentPayable instanceof SalariedEmployee)
         {
            // downcast Payable reference to 
            // BasePlusCommissionEmployee reference
        	 SalariedEmployee salariedEmployee = 
               ( SalariedEmployee ) currentPayable;

            double oldBaseSalary = salariedEmployee.getSalary();
            salariedEmployee.setSalary(oldBaseSalary * 1.1);
            System.out.printf( 
               "New salary with 10%% increase is: QR%,.2f\n",
               salariedEmployee.getSalary() );
         } // end if

         System.out.printf( "%s: $%,.2f\n\n",
            "payment due", currentPayable.getPaymentAmount() ); 
      } 
   } 
}