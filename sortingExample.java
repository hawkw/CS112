/**
* sortingExample.java
* @author Hawk Weisman
*/

import java.util.ArrayList;
import java.util.Collections;

public class sortingExample {

	public static void main (String[] argv) {
        
        ArrayList<String> a = new ArrayList();
        
        for (String arg : argv)
            a.add(arg);
        
        System.out.println ("Printing the unsorted list.");
        System.out.println (a);
        
        Collections.sort(a);
		
		System.out.println ("Printing the sorted list.");
        System.out.println (a);
        
	}
}