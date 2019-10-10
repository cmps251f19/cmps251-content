package tutorial4.excercise1;

// Processing Invoices with lambdas and streams.
import java.util.Comparator;
import java.util.List;

public class App {
   public static void main(String[] args) {
      List<Invoice> invoices = List.of(
         new Invoice(83, "Electric sander", 7, 57.98),
         new Invoice(24, "Power saw", 18, 99.99),
         new Invoice(7, "Sledge hammer", 11, 21.50),
         new Invoice(77, "Hammer", 76, 11.99),
         new Invoice(39, "Lawn mower", 3, 79.50),
         new Invoice(68, "Screwdriver", 106, 6.99),
         new Invoice(56, "Jig saw", 21, 11.00),
         new Invoice(3, "Wrench", 34, 7.50)
      );

      System.out.println("Invoices sorted by part description:");
      invoices.stream()
         .sorted(Comparator.comparing(Invoice::getItemDescription))
         .forEach(System.out::println);

      System.out.printf("%nInvoices sorted by price:%n");
      invoices.stream()
         .sorted(Comparator.comparing(Invoice::getPrice))
         .forEach(System.out::println);

      System.out.printf("%nInvoices mapped to description and quantity:%n");
      invoices.stream()
         .sorted(Comparator.comparing(Invoice::getQuantity))
         .map(invoice -> String.format(
            "Description: %-15s  Quantity: %d", 
            invoice.getItemDescription(), invoice.getQuantity()))
         .forEach(System.out::println);

      System.out.printf("%nInvoices mapped to description and invoice amount:%n");
      invoices.stream()
         .sorted(Comparator.comparingDouble(invoice -> invoice.getQuantity() * invoice.getPrice()))
         .map(invoice -> String.format(
            "Description: %-15s  Invoice amount: %7.2f", 
            invoice.getItemDescription(), invoice.getQuantity() * invoice.getPrice()))
         .forEach(System.out::println);

      System.out.printf("%nInvoices mapped to description and invoice amount for invoices in the range 200-500:%n");
      invoices.stream()
         .filter(invoice -> invoice.getQuantity() * invoice.getPrice()>= 200 && invoice.getQuantity() * invoice.getPrice() <= 500)
         .sorted(Comparator.comparingDouble(invoice -> invoice.getQuantity() * invoice.getPrice()))
         .map(invoice -> String.format(
            "Description: %-15s  Invoice amount: %7.2f", 
            invoice.getItemDescription(), invoice.getQuantity() * invoice.getPrice()))
         .forEach(System.out::println);
      
      System.out.printf("%nFind any one Invoice in which the partDescription contains the word \"saw\":%n");
      Invoice invoice = invoices.stream()
      	 .filter(i -> i.getItemDescription().indexOf("saw") > 0)
      	 .findFirst().get();
      
      System.out.println(invoice);
   }
}