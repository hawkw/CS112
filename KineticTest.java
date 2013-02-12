import junit.framework.*;

public class KineticTest extends TestCase 
{
  
  public KineticTest(String name) 
  {
    super(name);
  }
  
  public static Test suite() 
  {
    return new TestSuite(KineticTest.class);
  }
  
  public void testOne() 
  {
  
    String expected = new String("Undefined");
    String actual = Kinetic.computeVelocity(5,0);
    assertEquals(expected, actual);

  }

  public void testTwo() 
  {
  
    String expected = new String("0");
    String actual = Kinetic.computeVelocity(0,5);
    assertEquals(expected, actual);

  }

  public void testThree() 
  {
  
    String expected = new String("4");
    String actual = Kinetic.computeVelocity(8,1);
    assertEquals(expected, actual);

  }

  public void testFour() 
  {
    
    String expected = new String("20");
    String actual = Kinetic.computeVelocity(1000,5);

    System.out.println();
    System.out.println("Actual: " + actual);
    System.out.println("Expected: " + expected);

    assertEquals(expected, actual);

  }

}
