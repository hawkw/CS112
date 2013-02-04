// Written by Gregory M. Kapfhammer.  Adapted from the code in Goodrich and 
// Tamassia.

public class RecursiveFactorial
{

    public static void main(String[] args)
    {

	Integer arg1 = new Integer(args[0]);
/*
  	System.out.println("factorial(" + arg1 + ") = " +
  			   recursiveFactorial(arg1.intValue()));
 
 */

	System.out.println("factorialD(" + arg1 + ") = " +
			   recursiveFactorialD(arg1.intValue()));

	System.out.println(Integer.MAX_VALUE);

    }

    public static double recursiveFactorialD(int n) 
    {
        // base case
        if( n == 1 )
            {
                return (double)1.0;
            }

        else
            {
                // make sure that you call the D version!!!
                return (double)n * recursiveFactorialD(n-1);
            }
        }

    public static int recursiveFactorial(int n)
    {
	
	if( n == 1 )
	    {

		return 1;

	    }

	else
	    { 

		System.out.println("Call recursiveFactorial(" + (n-1) + ")");
		return n * recursiveFactorial(n-1);

	    }

    }
    
}
