import java.util.Scanner;  // Needed for the Scanner class

/*
   This program has a problem reading input.
*/

public class _2InputOutput
{
   public static void main(String[] args)
   {
      String name;   // To hold the user's name
      int age;       // To hold the user's age
      double income; // To hold the user's income
      
      // Create a Scanner object to read input.
      Scanner keyboard = new Scanner(System.in);

      // Get the user's name.
      System.out.print("What is your name? ");
      name = keyboard.nextLine();
      
      // Get the user's age.
      System.out.print("What is your age? ");
      age = keyboard.nextInt();
      
      // Get the user's income
      System.out.print("What is your annual income? ");
      income = keyboard.nextDouble();
      
      // Display the information back to the user.
      System.out.println("Hello, " + name + ". Your age is " +
                         age + " and your income is QR" +
                         income);
   }
}