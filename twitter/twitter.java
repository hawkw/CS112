/**
* Twitter.java
* @author Hawk Weisman
* PLEDGE:
*
* Reads a file containing tweets and sorts them into ArrayLists according to vailidity.
*/

import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
	
public class Twitter {	
	public static void main(String[] argv) {
		
		ArrayList<Tweet> validTweets = new ArrayList<Tweet>();		// stores all valid tweets
		ArrayList<String> invalidTweets = new ArrayList<String>();  // stores all invalid tweets
		
		File tweets;	// represents the tweets.txt file to be read from	
		Scanner scan;	// scanner to read tweets from tweets.txt
		
		final int MAX_LENGTH = 140;		// maximum length for a valid tweet
		final int MIN_LENGTH = 1;		// minimum length for a valid tweet
		
		String currentLine = new String();	// holds the string being sorted
		
		// setup LJV default context
		LJV.Context def = LJV.getDefaultContext( );
		    def.outputFormat = "png";
		    def.treatAsPrimitive( String.class );
			def.ignorePrivateFields = false;
		
		// try to set up the scanner
		try {
			tweets = new File ("tweets.txt");
			scan = new Scanner(tweets); 
			
			// loop through all the lines in tweets.txt and sort them into ArrayLists.
			while (scan.hasNextLine()) {
				currentLine = scan.nextLine();
				// if the tweet is valid, put it in the validTweets ArrayList
				if (Tweet.isValidMessage(currentLine) == true){
					Tweet tweet = new Tweet();
					tweet.setMessage(currentLine);
					validTweets.add(tweet);
					// otherwise, put it in invalidTweets
				} else {
					invalidTweets.add(currentLine);
				}
			}
		} 
			
		// handle any thrown exceptions by printing the stack trace
		catch (FileNotFoundException e){
			e.printStackTrace(System.err);
		} 
		
		// print out the valid tweets
		System.out.println("Valid tweets:");
		for (Tweet tweet : validTweets)
			System.out.println(tweet.toString());
		System.out.print("\n");
		
		// print out the invalid tweets
		System.out.println("Invalid tweets:");
		for (String invalidTweet : invalidTweets)
			System.out.println(invalidTweet);
		System.out.print("\n");
		
		// create LJV graph
		LJV.drawGraph (new Object[] {invalidTweets, validTweets});
	}
}