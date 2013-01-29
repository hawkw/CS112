/**
* CalcAvgLib.class
* 
* @author 	Hawk Weisman
* @version	0.1
* 
* Contains functionality brought over from CalcAvg
*/
	import java.lang.Math;

	public class CalcAvgLib {		
	
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
	}