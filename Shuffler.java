import java.util.ArrayList;
import java.util.Collections;

public class Shuffler
{

    public static void main(String[] args)
    {

	ArrayList list = new ArrayList();

	for(int i = 1; i <= 18; i++)
	    {

		list.add(i);

	    }

	System.out.println(list);

	Collections.shuffle(list);

	System.out.println(list);

    }

}