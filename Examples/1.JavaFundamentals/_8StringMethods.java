// This program demonstrates a few of the String methods.

public class _8StringMethods
{
   public static void main(String[] args)
   {
	  //Using var Java will implicitly derive the variable datatype
      var message  = "Java is Great Fun!";
      var upper = message.toUpperCase();
      var lower = message.toLowerCase();
      var letter = message.charAt(2);
      var stringSize = message.length();

      System.out.println(message);
      System.out.println(upper);
      System.out.println(lower);
      System.out.println(letter);
      System.out.println(stringSize);
   }
}