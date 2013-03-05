public class swappableIntSwap {

	public static void swap (SwappableInt a, SwappableInt b) {
		int temp;
		
		temp = a.getValue();
		a.setValue(b.getValue());
		b.setValue(temp);
	}
	
	public static void main (String[] argv) {
		SwappableInt a = new SwappableInt();
		SwappableInt b = new SwappableInt();
		
		a.setValue(Integer.parseInt(argv[0]));
		b.setValue(Integer.parseInt(argv[1]));
		
		System.out.println ("A = " + a.getValue());
		System.out.println ("B = " + b.getValue());
		
		swap (a,b);
		
		System.out.println("Swapping...");
		System.out.println ("A = " + a.getValue());
		System.out.println ("B = " + b.getValue());
	}
}