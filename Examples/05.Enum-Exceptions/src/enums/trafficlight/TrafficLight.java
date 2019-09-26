package enums.trafficlight;

/* Internally above enum TrafficLight is converted to 
class TrafficLight
{
     public static final TrafficLight RED = new TrafficLight();
     public static final TrafficLight GREEN = new TrafficLight();
     public static final TrafficLight YELLOW = new TrafficLight();
} */

// Declare an enum type with constructor and instance attributes 
// and accessors for these attributes
public enum TrafficLight {
   // declare constants of enum type                                
   RED(50), // light is red for 50 seconds
   GREEN(40), // light is green for 40 seconds
   YELLOW(5); // light is yellow for 5 seconds

   // instance attributes 
   private final int duration; // duration of the light in seconds

   // enum type constructor
   TrafficLight(int duration) {
      this.duration = duration;
   }

   // accessor for duration
   public int getDuration() {
      return duration;
   } 
}