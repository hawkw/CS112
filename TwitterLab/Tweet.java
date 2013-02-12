/**
 * Tweet.java
 * @author Hawk Weisman
 * PLEDGE:
 *
 * Represents a tweet for use in a Twitter client, with a date created,
 * message, and a method to test the tweet's validity.
 *
 */
	
import java.util.Date;	 
	 
public class Tweet {
	
	private Date currentDate;	// the date this Tweet was created
	private String message;	    // this string contains the String's message
	
	private static final int MIN_LENGTH = 1;   // minimum valid message length
	private static final int MAX_LENGTH = 140; // maximum valid message length
	
	/** 
     * Tweet(): constructor, initializes the Tweet with currentDate set to today's date
     * @author Hawk Weisman
     */ 
		 
	public Tweet () {
		this.currentDate = new Date();
	}

	/**
     * isValidMessage
     * @author Hawk Weisman
     * @param message The message whose validity is to be tested
     * @return Returns true if the message is valid, false if it is invalid. Messages are considered valid if they are between 1 and 140 characters.
     */
		 
	public static boolean isValidMessage (String message) {
		if (message.length() >= MIN_LENGTH && message.length() <= MAX_LENGTH) 
			return true;
		else
			return false;
	}
	
	/**
     * setMessage
     * @author Hawk Weisman
     * @param message The string to which this Tweet's message should be set.
     */
		 
	 public void setMessage (String message) {
		 this.message = message;
	 }
    
    /**
     * getMessage
     * @author Hawk Weisman
     * @return The message of this Tweet.
     */
    
    public String getMessage() {
        return this.message;
    }
	 
	 /**
	 * toString()
	 * @author Hawk Weisman
	 * @return Returns a string containing currentDate, message
	 */
		  
	public String toString() {
		return currentDate + ", " + message;
	} 
}