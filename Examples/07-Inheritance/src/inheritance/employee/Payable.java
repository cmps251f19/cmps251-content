package inheritance.employee;

public interface Payable 
{
   // By default methods are public abstract 
   double getAmount();

   public static final double SALE_TAX = 5;
   // By default attributes are public static final 
   double INCOME_TAX = 15.5;
   
   //By default all methods are public
   public default String amountToCurrency() {
	   return String.format("QR %.2f", getAmount());
   }
   
   public static String toCurrency(double amount) {
	   return String.format("QR %.2f", amount);
   }
}