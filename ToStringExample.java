import java.util.ArrayList;

public class ToStringExample
{

    public static void main(String[] args)
    {

	Object o = new Object();
	Object o1 = new Object();
	ArrayList list = new ArrayList();
	list.add(o);

	System.out.println("o : " + o);
	System.out.println("o1 : " + o1);
	System.out.println("list: " + list);

    }

}
