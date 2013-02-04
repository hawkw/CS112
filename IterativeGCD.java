// GCD.java Class demo by THC.  Converted to Java by Scot Drysdale.
// Computes the greatest common divisor of two integers by the
// Euclidean algorithm.

// Modified by Gregory M. Kapfhammer to not require use of Keyboard 
// class and only work in a cmd-line fashion with one run of program.

public class IterativeGCD
{
  public static void main(String[] args)
  {
   
      // assume that two arguments are provided on the command line
      Integer arg1 = new Integer(args[0]);
      Integer arg2 = new Integer(args[1]);

      int n = arg1.intValue();
      int m = arg2.intValue();

      System.out.println("The GCD(" + arg1 + "," + arg2 + ") = " +
			 gcd(n,m));

  }

  // Iterative GCD function.
  public static int gcd(int a, int b)
  {
  
      int r;          // Hold the remainder
      int counter = 0;
  
      do 
	  {
	      r = a % b;
	      a = b;
	      b = r;

 	      System.out.println("r = " + r);
 	      System.out.println("a = " + a);
 	      System.out.println("b = " + b);

	      counter++;

	  }
      while (r > 0);
  

      System.out.println("counter = " + counter);

      return a;
  
  }
    
}
