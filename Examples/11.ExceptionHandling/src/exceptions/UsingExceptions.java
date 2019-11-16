package exceptions;
// Fig. 11.4: UsingExceptions.java
// try...catch...finally exception handling mechanism.

public class UsingExceptions 
{
   public static void main( String[] args )
   {
      try 
      { 
         throwException(); // call method throwException
      } 
      catch ( Exception exception ) // exception thrown by throwException
      {
         System.out.println( "Exception handled in main" );
      }

      doesNotThrowException();
   } 

   public static void throwException() throws Exception
   {
      try 
      { 
         System.out.println( "I ma inside throwException method" );
         throw new Exception("Exception thrown by throwException method"); // generate exception
      }
      catch ( Exception exception )
      {
         System.out.println("Exception handled in method throwException then it was rethrown" );
         throw exception; // rethrow for further processing
      }
      finally // executes regardless of what occurs in try...catch
      {
         System.out.println( "Finally executed in throwException" );
      }

   }

   // demonstrate finally when no exception occurs
   public static void doesNotThrowException()
   {
      try
      { 
         System.out.println( "I am inside doesNotThrowException method" );
      }
      catch ( Exception exception ) // does not execute
      {
         System.out.println( exception );
      }
      finally // executes regardless of what occurs in try...catch
      {
         System.out.println("Finally executed in doesNotThrowException method" );
      }

      System.out.println( "End of doesNotThrowException method" );
   }
}