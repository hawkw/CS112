/**
* CalcAvg.java 
* 
* @author 	Hawk Weisman
* @version	0.1
* 
* Calculates the mean, median, and mode for a set of doubles.
* The doubles are given as command-line arguments for the program.
*/
	import java.util.Scanner;
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
			
		public static void main (String[] argv) {
			
			int numValues = Integer.parseInt(argv[0]);		// the number of values to be calculated
			double[] values = new double[numValues];		// stores the values
			
			Scanner scan = new Scanner(System.in);

			for (int i = 0; i < numValues; i++) {
				System.out.println ("Please enter value " + (i+1) + ".");
				values[i] = scan.nextDouble();
			}
			
			System.out.println("The arithmatic mean is: " + mean(values) + ".");
			
		}
	}