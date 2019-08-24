import java.util.Scanner;

public class _4IfElse
{
    public static void main(String[] args)
    {
        // welcome the user to the program
        System.out.println("Welcome to the Invoice Total Calculator");
        System.out.println();  // print a blank line

        // create a Scanner object named sc
        Scanner scanner = new Scanner(System.in);

        // perform invoice calculations until choice isn't equal to "y" or "Y"
        String choice = "y";
        while (choice.equalsIgnoreCase("y"))
        {
            // get the invoice subtotal from the user
            System.out.print("Enter invoice amount:   ");
            double invoiceAmount = scanner.nextDouble();

            // calculate the discount amount and total
            double discountPercent;
            if (invoiceAmount >= 200)
                discountPercent = .2;
            else if (invoiceAmount >= 100)
                discountPercent = .1;
            else
                discountPercent = 0.0;
            
            double discountAmount = invoiceAmount * discountPercent;
            double amountToPay = invoiceAmount - discountAmount;

            // display the discount amount and total
            String message = "Discount percent: " + discountPercent + "\n"
                    + "Discount amount:  " + discountAmount + "\n"
                    + "Invoice total:    " + amountToPay + "\n";
            System.out.println(message);

            // see if the user wants to continue
            System.out.print("Continue? (y/n): ");
            choice = scanner.next();
            System.out.println();
        }
        scanner.close();
    }
}