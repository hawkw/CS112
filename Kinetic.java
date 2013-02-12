import java.lang.Math;

public class Kinetic
{

  public static String computeVelocity(int kinetic, int mass)
  {

    int velocity_squared = 0;
    int velocity = 0;
    StringBuffer final_velocity = new StringBuffer();

    //System.out.println("F V: " + velocity);
    //System.out.println("F V squared: " + velocity_squared);

    if( mass != 0 )
    {

      velocity_squared = 3 * (kinetic / mass);
      velocity = (int)Math.sqrt(velocity_squared);
      final_velocity.append(velocity);

    }

    else
    {

      final_velocity.append("Undefined");

    }

    //System.out.println("L V: " + velocity);
    //System.out.println("L V squared: " + velocity_squared);

    return final_velocity.toString();

  }

}
