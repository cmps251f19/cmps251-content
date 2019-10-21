package inheritance.employee;

public class Invoice implements Payable
{
   private String partNumber; 
   private String partDescription;
   private int quantity;
   private double unitPrice;

   public Invoice( String partNumber, String partDescription, int quantity, 
      double unitPrice )
   {
      this.partNumber = partNumber;
      this.partDescription = partDescription;
      setQuantity( quantity );
      setUnitPrice( unitPrice );
   }

   public void setPartNumber( String part )
   {
      partNumber = part;  
   }

   public String getPartNumber()
   {
      return partNumber;
   }
   
   public void setPartDescription( String description )
   {
      partDescription = description;
   }
   
   public String getPartDescription()
   {
      return partDescription;
   }
   
   public void setQuantity( int quantity )
   {
      this.quantity = ( quantity < 0 ) ? 0 : quantity; // quantity cannot be negative
   }
   
   public int getQuantity()
   {
      return quantity;
   } 
   
   public void setUnitPrice( double unitPrice )
   {
      this.unitPrice = ( unitPrice < 0.0 ) ? 0.0 : unitPrice; 
   }

   public double getUnitPrice()
   {
      return unitPrice;
   } 
   
   // Implements the Payable interface
   public double getPaymentAmount() 
   {
      return getQuantity() * getUnitPrice(); // calculate total cost
   }
   
   public String toString()
   {
      return String.format( "%s: \n%s: %s (%s) \n%s: %d \n%s: $%,.2f", 
         "invoice", "part number", getPartNumber(), getPartDescription(), 
         "quantity", getQuantity(), "price per item", getUnitPrice() );
   }
}