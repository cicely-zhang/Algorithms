package design;

import java.util.*;

public class MiniTwitter {
	
	private HashMap<Integer, List<Integer>> friendship;
    private HashMap<Integer, List<Tweet>> userTweets;
    private HashMap<Integer, List<Tweet>> newsFeed;
    
    public MiniTwitter() {
        // initialize your data structure here.
        friendship = new HashMap<Integer, List<Integer>>();
        userTweets = new HashMap<Integer, List<Tweet>>();
        newsFeed = new HashMap<Integer, List<Tweet>>();
    }

    // @param user_id an integer
    // @param tweet a string
    // return a tweet
    public Tweet postTweet(int user_id, String tweet_text) {
        //  Write your code here
        Tweet tweet = Tweet.create(user_id, tweet_text);
        if (!userTweets.containsKey(user_id)) 
            userTweets.put(user_id, new ArrayList<Tweet>());
        
        List<Tweet> tweets = userTweets.get(user_id);
        tweets.add(tweet);
        
        if (!newsFeed.containsKey(user_id))
            newsFeed.put(user_id, new ArrayList<Tweet>());
            
        List<Tweet> myNewsFeed = newsFeed.get(user_id);
        
        if (myNewsFeed.size() > 10) {
            myNewsFeed.remove(0);
            myNewsFeed.add(tweet);
        }
        else {
            myNewsFeed.add(tweet);
        }
        
        if (friendship.containsKey(user_id)) {
            for (Integer friend : friendship.get(user_id)) {
                if (!newsFeed.containsKey(friend))
                    newsFeed.put(friend, new ArrayList<Tweet>());
                
                List<Tweet> topFeeds = newsFeed.get(friend);
                if (topFeeds.size() > 10) {
                    topFeeds.remove(0);
                    topFeeds.add(tweet);
                }
                else {
                    topFeeds.add(tweet);
                }
            }
        }
        
        return tweet;
    }

    // @param user_id an integer
    // return a list of 10 new feeds recently
    // and sort by timeline
    public List<Tweet> getNewsFeed(int user_id) {
        // Write your code here
        return newsFeed.get(user_id);
    }
        
    // @param user_id an integer
    // return a list of 10 new posts recently
    // and sort by timeline
    public List<Tweet>  getTimeline(int user_id) {
        // Write your code here
        if (userTweets.containsKey(user_id)) {
            
            List<Tweet> myTweets = userTweets.get(user_id);
            if (myTweets.size() < 10)
                return myTweets;
            else {
                return userTweets.get(user_id).subList(userTweets.size()-10, userTweets.size());
            }
        }
        return new ArrayList<Tweet>();
    }

    // @param from_user_id an integer
    // @param to_user_id an integer
    // from user_id follows to_user_id
    public void follow(int from_user_id, int to_user_id) {
        // Write your code here
        if (!friendship.containsKey(from_user_id))
            friendship.put(from_user_id, new ArrayList<Integer>());
        
        List<Integer> followees = friendship.get(from_user_id);
        followees.add(to_user_id);
    }

    // @param from_user_id an integer
    // @param to_user_id an integer
    // from user_id unfollows to_user_id
    public void unfollow(int from_user_id, int to_user_id) {
        // Write your code here
        if (!friendship.containsKey(from_user_id))
            return;
            
        friendship.get(from_user_id).remove((Integer) to_user_id);
    }
    
    public static void main(String[] args) {
    	MiniTwitter miniTwitter = new MiniTwitter();
    	
    	System.out.println(miniTwitter.postTweet(1, "LintCode is Good!!!"));
    	System.out.println(miniTwitter.getNewsFeed(1));
    	System.out.println(miniTwitter.getTimeline(1));
    	miniTwitter.follow(2, 1);
    	System.out.println(miniTwitter.getNewsFeed(2));
    	miniTwitter.unfollow(2, 1);
    	System.out.println(miniTwitter.getNewsFeed(2));
    }

}
