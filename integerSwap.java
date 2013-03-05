public class integerSwap {

	public static void swap (int a, int b) {
		int temp;
		
		temp = a;
        a = b;
        b = temp;
	}
    
    public static void swap (Integer a, Integer b) {
		int temp;
		
		temp = a.intValue();
        a = new Integer (b.intValue());
        b = new Integer(temp);
	}
	
	public static void main (String[] argv) {
        int a = 10;
        int b = 20;
		
		System.out.println ("a = " + a);
		System.out.println ("b = " + b);
		
		swap (a,b);
		
		System.out.println ("a = " + a);
		System.out.println ("b = " + b);
		
        Integer A = new Integer(a);
        Integer B = new Integer(b);
        
		System.out.println ("A = " + A.intValue());
		System.out.println ("B = " + B.intValue());
		
		swap (A, B);
		
		System.out.println ("A = " + A.intValue());
		System.out.println ("B = " + B.intValue());
	}
}