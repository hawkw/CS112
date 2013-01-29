/**
* CalcAvg.java 
* 
* @author 	Hawk Weisman
* @version	0.2
* 
* Calculates the mean, median, and mode for a set of doubles.
* The doubles are given as command-line arguments for the program.
*/
	import java.lang.Math;
	import java.util.Scanner;
	
	package CalcAvg;
	
	public class CalcAvg {
		
		/**
		* mean
		* @author	Hawk Weisman
		* @param	An array of doubles to be calculated.
		* @return 	The arithmatic mean of the array passed as an argument.
		*/
		public static double mean (double[] input) {
			double result = 0;
			for (int i = 0; i < input.length; i++) {
				result = result + input[i];
			}
			return result/(input.length+1);
		}
		
		/**
		* sigma
		* @author	Hawk Weisman
		* @param	An array of doubles to be calculated.
		* @return 	The statistical margin of error.
		*/
		public static double sigma (double[] input) {
			
			double[] calculating = new double [input.length];
			double result = 0;
			
			for (int i = 0; i < input.length; i++) {
				calculating[i] = Math.pow((input[i] - mean(input)), 2.0);
			}
			return Math.sqrt(mean(calculating));
		}
			
		public static void main (String[] argv) {
			
			int numValues = Integer.parseInt(argv[0]);		// the number of values to be calculated
			double[] values = new double[numValues];		// stores the values
			
			Scanner scan = new Scanner(System.in);

			for (int i = 0; i < numValues; i++) {
				System.out.println ("Please enter value " + (i+1) + ".");
				values[i] = scan.nextDouble();
			}
			
			System.out.println ("The arithmatic mean is: " + mean(values) + ".");
			
			System.out.println ("The standard deviation is: " + sigma(values) + ".");
			
		}
	}