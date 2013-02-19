import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;
import twitter4j.conf.ConfigurationBuilder;
import twitter4j.conf.Configuration;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.FileOutputStream;

public final class TwitterCreateProperties {

    public static void main(String[] args) {
       
    	ConfigurationBuilder cb = new ConfigurationBuilder();
    	
    	cb.setDebugEnabled(true)
	    .setOAuthConsumerKey("87phzuHwuARcCwAjgVUYww")
	    .setOAuthConsumerSecret("D9AAkdfQcWR04CuU4IL4s3tVLxiijsez276ldayTng");
  
        try {
            TwitterFactory tf = new TwitterFactory(cb.build());
            Twitter twitter = tf.getInstance();
            
            try {

                // get request token.
                // this will throw IllegalStateException if access token is already available
                // this is oob, desktop client version
                RequestToken requestToken = twitter.getOAuthRequestToken(); 

                System.out.println("Got request token.");
                System.out.println("Request token: " + requestToken.getToken());
                System.out.println("Request token secret: " + requestToken.getTokenSecret());

                AccessToken accessToken = null;

                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                
                // while the access token has yet to be generated
                while (null == accessToken) {
                    // prompt the user to visit the authorization URL
                    System.out.println("Open the following URL and grant access to your account:");
                    System.out.println(requestToken.getAuthorizationURL());
                    // prompt the user for the PIN number
                    System.out.print("Enter the PIN and hit enter after you granted access. [PIN]:");
                    String pin = br.readLine();
               
                    try {
                        if (pin.length() > 0) {
                            // if there is a PIN, set the accessToken with the requestToken and the PIN
                            accessToken = twitter.getOAuthAccessToken(requestToken, pin);
                        } else {
                            // if there is no PIN, set the accessToken with just the requestToken
                            accessToken = twitter.getOAuthAccessToken(requestToken);
                        }
            
                    } catch (TwitterException te) {
                        if (401 == te.getStatusCode()) {
                            System.out.println("Unable to get the access token.");
                        } else {
                            te.printStackTrace();
                        }
                    }
                }
		
		// produce useful debugging output for the access tokens
                System.out.println("Got access token.");
                System.out.println("Access token: " + accessToken.getToken());
                System.out.println("Access token secret: " + accessToken.getTokenSecret());

		try {
            // create the new properties file with the oauth keys and tokens
		    System.out.println("Writing the properties file");
		    BufferedWriter out = new BufferedWriter(new FileWriter("twitter4j.properties"));
		    out.write("debug=true\n");
		    out.write("oauth.consumerKey=87phzuHwuARcCwAjgVUYww\n");
		    out.write("oauth.consumerSecret=D9AAkdfQcWR04CuU4IL4s3tVLxiijsez276ldayTng\n");
		    out.write("oauth.accessToken=" + accessToken.getToken() + "\n");
		    out.write("oauth.accessTokenSecret=" + accessToken.getTokenSecret() + "\n");
		    out.close();
		}

		catch (IOException e) {
		    e.printStackTrace();
		}
		
	    }

	    catch (IllegalStateException ie) {
                // access token is already available, or consumer key/secret is not set.
                if (!twitter.getAuthorization().isEnabled()) {
                    System.out.println("OAuth consumer key/secret is not set.");
                    System.exit(-1);
                }
            }
            
        } catch (TwitterException te) {
            te.printStackTrace();
            System.out.println("Failed to get timeline: " + te.getMessage());
            System.exit(-1);
        } catch (IOException ioe) {
            ioe.printStackTrace();
            System.out.println("Failed to read the system input.");
            System.exit(-1);
        }
    }
}
