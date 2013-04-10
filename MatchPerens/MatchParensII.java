import java.util.Stack;

/** Simple matching parentheses program using a Stack */

public class MatchParensII
{

    public static final String LEFTPAREN = "(";
    public static final String RIGHTPAREN = ")";
    public static final String LEFTCURLY = "{";
    public static final String RIGHTCURLY = "}";
    public static final String LEFTSQUARE = "[";
    public static final String RIGHTSQUARE = "]";

    /** Main entry point for the program.  We will use the
	ConsoleReader to read in a string and then parse 
	it and use the Stack to perform the matching.        
     **/
    public static void main(String[] args) {

	// create the stack that we will use for the 
	// matching of the parens
	Stack<String> parenStack = new Stack<String>();
    Stack<String> curlyStack = new Stack<String>();
    Stack<String> squareStack = new Stack<String>();

	// flag that will be used in order to perform matching
	boolean matching = true;

	// read in the string from the usr 
	ConsoleReader reader = new ConsoleReader(System.in);
	String parens = reader.readLine();
	
	// go through each position inside of the 
	// string and perform the correct operation
	// using the Stack (need to match)
	for(int i = 0; i < parens.length(); i++) {
		
		// extract the current paren
		String currentParen = parens.substring(i, i+1);

		System.out.println("Examining:" + 
				   currentParen);
		
		switch (currentParen) {
			case LEFTPAREN:
				parenStack.push(currentParen);
				break;
			case RIGHTPAREN:
				if( !parenStack.isEmpty() ) { 
					parenStack.pop();
					} else {
						matching = false;
					}
				break;
			case LEFTCURLY:
				curlyStack.push(currentParen);
				break;
			case RIGHTCURLY:
            	if( !curlyStack.isEmpty() ) {
                	curlyStack.pop(); 
		   			} else {
                		matching = false;
		   	 		}
				break;
			case LEFTSQUARE:
				squareStack.push(currentParen);   
				break;
			case RIGHTSQUARE:
				if( !squareStack.isEmpty() ) { 
					squareStack.pop();
					} else {
						matching = false;
					}
				break;
			default:
			// fall through and continue
				break;
			}
		}

	// your code here will determine whether or not the 
	// string of parentheses was "matching" or "non-matching"

        if (matching == true && parenStack.empty() && curlyStack.empty() && squareStack.empty()){
            System.out.println ("Matching.");
        } else {
            System.out.println ("Not matching");

        }
    }
}
