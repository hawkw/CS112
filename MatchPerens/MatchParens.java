import java.util.Stack;

/** Simple matching parentheses program using a Stack */

public class MatchParens
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
    public static void main(String[] args)
    {

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
	for(int i = 0; i < parens.length(); i++)
	    {
		
		// extract the current paren
		String currentParen = parens.substring(i, i+1);

		System.out.println("Examining:" + 
				   currentParen);
		
		// we found a LEFTPAREN ---> push
		if( currentParen.equals(LEFTPAREN) )
		    {
				parenStack.push(currentParen);
		    }

		// we fond a RIGHTPAREN --> pop
		else if( currentParen.equals(RIGHTPAREN) )
		    {

			// do not pop if the stack is 
			// already empty
			if( !parenStack.isEmpty() )
			    {
				
				// disregard the output of pop()
				parenStack.pop();
				
			    }

			// the stack was empty, but we saw a 
			// right paren, thus there must be 
			// a non-matching string
			else
			    {

				matching = false;

			    }

		    }
            
            // we found a LEFTCURLY ---> push
            if( currentParen.equals(LEFTCURLY) )
		    {
                
                curlyStack.push(currentParen);
                
		    }

            
            // we fond a RIGHTPAREN --> pop
            else if( currentParen.equals(RIGHTCURLY) )
		    {
                
                // do not pop if the stack is
                // already empty
                if( !curlyStack.isEmpty() )
			    {
                    
                    // disregard the output of pop()
                    curlyStack.pop();
                    
			    }
                
                // the stack was empty, but we saw a
                // right paren, thus there must be
                // a non-matching string
                else
			    {
                    
                    matching = false;
                    
			    }
                
		    }
            
            // we found a LEFTCURLY ---> push
            if( currentParen.equals(LEFTSQUARE) )
		    {
                
                squareStack.push(currentParen);
                
		    }
            // we fond a RIGHTPAREN --> pop
            else if( currentParen.equals(RIGHTSQUARE) )
		    {
                
                // do not pop if the stack is
                // already empty
                if( !squareStack.isEmpty() )
			    {
                    
                    // disregard the output of pop()
                    squareStack.pop();
                    
			    }
                
                // the stack was empty, but we saw a 
                // right paren, thus there must be 
                // a non-matching string
                else
			    {
                    
                    matching = false;
                    
			    }
                
		    }

	    }

	// your code here will determine whether or not the 
	// string of parentheses was "matching" or "non-matching"

        if (matching == false || !parenStack.empty() || !curlyStack.empty() || !squareStack.empty()){
            System.out.println ("The perentheses do not match.");
        } else {
            System.out.println ("The perentheses match!");

        }

    }

}
