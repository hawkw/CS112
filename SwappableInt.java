/**
 * SwappableInt
 * @author Hawk Weisman
 */
public class SwappableInt {
	
	private int value;
	
    /**
     * SwappableInt
     * @author Hawk Weisman
     */
    public SwappableInt () {
        this.value = 0;
    }
    
    /**
     * SwappableInt
     * @author Hawk Weisman
     * @param value The initial value for this SwappableInt
     */
	public SwappableInt(int value) {
		this.value = value;
	}
	
    /**
     * setValue
     * @author Hawk Weisman
     * @param value The value to which this SwappableInt's value should be set
     */
	public void setValue(int value) {
		this.value = value;
	}
	
    /**
     * getValue
     * @author Hawk Weisman
     * @return The current value of this SwappableInt
     */
	public int getValue() {
		return value;
	}

}