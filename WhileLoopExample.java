public class WhileLoopExample
{

    public static void main(String[] args)
    {

	// assume that the rate is a whole number
	// (right now it is just 10% 
	int rate = 10;

	// assume that the starting balance is 1000 dollars
	double balance = 1000.00;

	// calculate interest for twenty years
	final int YEAR = 20;
	int i = 1;
	
	for (i = 0; i <= YEAR; i++)
	    {

		double interest = balance * (rate/100);
		balance = balance + interest;

		System.out.println("Calculating Interest for Year = " + i);
		System.out.println("Balance = " + balance);

	    }
	
    }

}
