package quBookstore;

import java.util.Scanner;

public class DataEntryUtils {

    public static String getString(Scanner scanner, String prompt) {
        System.out.print(prompt);
        String s = scanner.next();  // read user entry
        scanner.nextLine();  // discard any other data entered on the line
        return s;
    }

    public static int getInt(Scanner scanner, String prompt) {
        boolean isValid = false;
        int i = 0;
        while (isValid == false) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                i = scanner.nextInt();
                isValid = true;
            } else {
                System.out.println("Error! Invalid integer value. Try again.");
            }
            scanner.nextLine();  // discard any other data entered on the line
        }
        return i;
    }

    public static int getInt(Scanner scanner, String prompt,
            int min, int max) {
        int i = 0;
        boolean isValid = false;
        while (isValid == false) {
            i = getInt(scanner, prompt);
            if (i <= min) {
                System.out.println(
                        "Error! Number must be greater than " + min + ".");
            } else if (i >= max) {
                System.out.println(
                        "Error! Number must be less than " + max + ".");
            } else {
                isValid = true;
            }
        }
        return i;
    }

    public static double getDouble(Scanner scanner, String prompt) {
        boolean isValid = false;
        double d = 0;
        while (!isValid) {
            System.out.print(prompt);
            if (scanner.hasNextDouble()) {
                d = scanner.nextDouble();
                isValid = true;
            } else {
                System.out.println("Error! Invalid decimal value. Try again.");
            }
            scanner.nextLine();  // discard any other data entered on the line
        }
        return d;
    }

    public static double getDouble(Scanner scanner, String prompt,
            double min, double max) {
        double d = 0;
        boolean isValid = false;
        while (isValid == false) {
            d = getDouble(scanner, prompt);
            if (d <= min) {
                System.out.println(
                        "Error! Number must be greater than " + min + ".");
            } else if (d >= max) {
                System.out.println(
                        "Error! Number must be less than " + max + ".");
            } else {
                isValid = true;
            }
        }
        return d;
    }
}