package enums.trafficlight;

// Declare an enum type with constructor and explicit instance attributes 
// and accessors for these attributes
public enum TrafficLight {
   // declare constants of enum type                                
   RED(50), // light is red for 50 seconds
   GREEN(40), // light is green for 40 seconds
   YELLOW(5); // light is yellow for 5 seconds

   // instance attributes 
   private final int duration; // duration of the light

   // enum type constructor
   TrafficLight(int durationSeconds) {
      duration = durationSeconds;
   }

   // accessor for duration
   public int getDuration() {
      return duration;
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
