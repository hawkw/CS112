// Written by Gregory M. Kapfhammer.  Adapted from the code in Goodrich and 
// Tamassia.

public class IterativeFactorial
{

    public static void main(String[] args)
    {

        Integer arg1 = new Integer(args[0]);

        /* System.out.println("factorial(" + arg1 + ") = " +
			   iterativeFactorial(arg1.intValue())); */

        System.out.println("factorialD(" + arg1 + ") = " +
			   iterativeFactorialD(arg1.intValue()));

    }

    public static double iterativeFactorialD(int n)
    {
        
        double result = 1.0;
	
        for (int i = 1; i <= n; i++)
            {
		
                result *= (double)i;
	
            }

            return result;

        }

    // http://www.comp.lancs.ac.uk/computing/users/rgg/jfcBook/examples/chap18/
    //        Chapter18n2.java
    public static int iterativeFactorial(int n)
    {

	int result = 1;
	
	for (int i = 1; i <= n; i++)
	    {
		
		result *= i ;
	
	    }

        return result ;

    }

}
