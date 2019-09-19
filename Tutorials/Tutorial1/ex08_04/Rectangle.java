// Exercise 8.4 Solution: Rectangle.java
// Definition of class Rectangle

public class Rectangle {
   private double length; // the length of the rectangle
   private double width; // the width of the rectangle

   // constructor without parameters
   public Rectangle() {
      this(1.0, 1.0);
   } 

   // constructor with length and width supplied
   public Rectangle(double length, double width) {
      setLength(length);
      setWidth(width);
   } 

   // validate and set length
   public void setLength(double length) {
      if (length <= 0.0 || length >= 20.0) {
         throw new IllegalArgumentException("length out of range");
      }

      this.length = length;
   }

   // validate and set width
   public void setWidth(double width) {
      if (width <= 0 || width >= 20.0) {
         throw new IllegalArgumentException("width out of range");
      }

      this.width = width;
   } 

   // get value of length
   public double getLength() {
      return length;
   } 

   // get value of width
   public double getWidth() {
      return width;
   } 

   // calculate rectangle's perimeter
   public double getPerimeter() { 
      return 2 * getLength() + 2 * getWidth();
   } 

   // calculate rectangle's area
   public double getArea() {
      return getLength() * getWidth();
   }

   // convert to String
   public String toString() {
      return String.format("%s: %f%n%s: %f%n%s: %f%n%s: %f",
         "Length", getLength(), "Width", getWidth(),
         "Perimeter", getPerimeter(), "Area", getArea());
   } 
}



/**************************************************************************
 * (C) Copyright 1992-2018 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/
