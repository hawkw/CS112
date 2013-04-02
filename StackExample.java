import java.util.Stack;

public class StackExample
{

    public static void main(String[] args)
    {

	Stack<Integer> exampleStack = new Stack<Integer>();
	exampleStack.push(new Integer(10));
	exampleStack.push(20);
	exampleStack.push(30);
	exampleStack.push(40);

	System.out.println(exampleStack);

        
        Integer value = (Integer)exampleStack.pop();
        System.out.println(value);

        
        if (exampleStack.empty() == false) {
            value = (Integer)exampleStack.pop();
            System.out.println(value);
        }

        if (exampleStack.empty() == false) {
            value = (Integer)exampleStack.pop();
            System.out.println(value);
        }

        if (exampleStack.empty() == false) {
            value = (Integer)exampleStack.pop();
            System.out.println(value);
        }

        if (exampleStack.empty() == false) {
            value = (Integer)exampleStack.pop();
            System.out.println(value);
        }

        if (exampleStack.empty() == false) {
            value = (Integer)exampleStack.pop();
            System.out.println(value);
        }

    }

}