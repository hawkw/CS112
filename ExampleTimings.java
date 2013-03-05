import com.clarkware.Profiler;

import java.io.PrintWriter;

public class ExampleTimings
{

    public static void main(String[] args)
    {

	Long input = new Long(args[0]);
	long n = input.longValue();

	String type = new String(args[1]);

	if( type.equals("constant") )
	    {

		Profiler.begin("Constant Time");
		int a = 10;
		Profiler.end("Constant Time");

	    }

	if( type.equals("linear") )
	    {

		int l = 0;
		Profiler.begin("Linear Time");
		for(int i = 0; i < n; i++)
		    {

			l++;

		    }
		Profiler.end("Linear Time");

	    }

	if( type.equals("quadratic") )
	    {

		int q = 0;
		Profiler.begin("Quadratic Time");
		for(int i = 0; i < n; i++)
		    {

			for(int j = 0; j < n; j++)
			    {

				q++;

			    }

		    }
		Profiler.end("Quadratic Time");

	    }

	if( type.equals("cubic") )
	    {

		int c = 0;
		Profiler.begin("Cubic Time");
		for(int i = 0; i < n; i++)
		    {
			
			for(int j = 0; j < n; j++)
			    {

				for(int k = 0; k < n; k++)
				    {

					c++;

				    }

			    }

		    }
		Profiler.end("Cubic Time");

	    }

	System.out.println();
	Profiler.print(new PrintWriter(System.out));

    }

}
