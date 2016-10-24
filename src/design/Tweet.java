package design;

public class Tweet {
     public int id;
     public int user_id;
     public String text;
    
     
     private static int globalCount = 0;
     public static Tweet create(int user_id, String tweet_text) {
         // This will create a new tweet object,
         // and auto fill id
    	 Tweet tweet = new Tweet();
    	 tweet.id = globalCount + 1;
    	 tweet.user_id = user_id;
    	 tweet.text = tweet_text;
    	 return tweet;
     }
   }
