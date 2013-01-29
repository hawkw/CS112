/**
* StatOMat.java 
* 
* @author 	Hawk Weisman
* @version	0.2
* 
* Calculates the mean, median, and mode for a set of doubles.
* 
*	+---------------------------------------------------+
*	| Command-line arguments: double A, int B			|
*	| Double A sets the number of values to analyze,	|
*	| while int B sets the number of decimal places		|
*	| to which outputs should be rounded (NYE).			|
*	+---------------------------------------------------+
*/
	import java.lang.Math;
	import java.util.Scanner;
	
	public class StatOMat {	
		
		public static void main (String[] argv) {
			
			try {
				int numValues = Integer.parseInt(argv[0]);		// the number of values to be calculated
				double[] values = new double[numValues];		// stores the values
			
				Scanner scan = new Scanner(System.in);

				for (int i = 0; i < numValues; i++) {
					System.out.println ("Please enter value number " + (i+1) + ".");
					values[i] = scan.nextDouble();
				}
			
				System.out.println ("The arithmatic mean is: " + CalcAvgLib.mean(values) + ".");
				System.out.println ("The standard deviation is: " + CalcAvgLib.sigma(values) + ".");
			}
		
		catch (Exception e){
			e.printStackTrace(System.out);
		}
			
		}
	}