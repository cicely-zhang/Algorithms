package design;

import java.util.*;

public class MiniTwitter {
	//To do: how to add the comparator to Tweet class instead
	
    private HashMap<Integer, HashSet<Integer>> friendship;
    private HashMap<Integer, List<Tweet>> userTweets;
    private HashMap<Integer, PriorityQueue<Tweet>> newsFeed;
    private Comparator<Tweet> comparator;
    
    public MiniTwitter() {
        // initialize your data structure here.
        
        comparator = new Comparator<Tweet>() {
            public int compare(Tweet t1, Tweet t2) {
                if (t1 == null)
                    return -1;
                else if (t2 == null)
                    return 1;
                    
                return t1.id - t2.id;
            }
        };
        
        friendship = new HashMap<Integer, HashSet<Integer>>();
        userTweets = new HashMap<Integer, List<Tweet>>();
        newsFeed = new HashMap<Integer, PriorityQueue<Tweet>>();
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
        tweets.add(0, tweet);
        
        if (!newsFeed.containsKey(user_id))
            newsFeed.put(user_id, new PriorityQueue<Tweet>(10, comparator));
            
        PriorityQueue<Tweet> myNewsFeed = newsFeed.get(user_id);
        myNewsFeed.add(tweet);
        
        if (friendship.containsKey(user_id)) {
            for (Integer friend : friendship.get(user_id)) {
                if (!newsFeed.containsKey(friend))
                    newsFeed.put(friend, new PriorityQueue<Tweet>(10, comparator));
                
                PriorityQueue<Tweet> topFeeds = newsFeed.get(friend);
                topFeeds.add(tweet);
            }
        }
        
        return tweet;
    }

    // @param user_id an integer
    // return a list of 10 new feeds recently
    // and sort by timeline
    public List<Tweet> getNewsFeed(int user_id) {
        // Write your code here
        if (newsFeed.containsKey(user_id)) {
            ArrayList<Tweet> myfeeds = new ArrayList<Tweet>();
            PriorityQueue<Tweet> cloned = new PriorityQueue<Tweet>(newsFeed.get(user_id));
            int i = 0;
            while (cloned.size() > 10)
                cloned.poll();
            while (cloned.size() > 0)
                myfeeds.add(0, cloned.poll());

            return myfeeds;
        }
        return new ArrayList<Tweet>();
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
                return userTweets.get(user_id).subList(0,10);
            }
        }
        return new ArrayList<Tweet>();
    }

    // @param from_user_id an integer
    // @param to_user_id an integer
    // from user_id follows to_user_id
    public void follow(int from_user_id, int to_user_id) {
        // Write your code here
        if (from_user_id == to_user_id)
            return;
            
        if (!friendship.containsKey(to_user_id))
            friendship.put(to_user_id, new HashSet<Integer>());
        
        HashSet<Integer> followees = friendship.get(to_user_id);
        if (!followees.contains(from_user_id))
            followees.add(from_user_id);
            
        //add to_user_id's tweets to my news feed
        if (!newsFeed.containsKey(from_user_id))
            newsFeed.put(from_user_id, new PriorityQueue<Tweet>(10, comparator));
            
        PriorityQueue<Tweet> myfeeds = newsFeed.get(from_user_id);
        for (Tweet tweet : getTimeline(to_user_id)) {
            myfeeds.add(tweet);
        }
    }

    // @param from_user_id an integer
    // @param to_user_id an integer
    // from user_id unfollows to_user_id
    public void unfollow(int from_user_id, int to_user_id) {
        // Write your code here
        if (!friendship.containsKey(to_user_id))
            return;
            
        friendship.get(to_user_id).remove((Integer) from_user_id);
        
        if (newsFeed.containsKey(from_user_id)) {
            PriorityQueue<Tweet> myfeeds = newsFeed.get(from_user_id);
            for (Tweet tweet : getTimeline(to_user_id)) {
                myfeeds.remove(tweet);
            }
        }
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
