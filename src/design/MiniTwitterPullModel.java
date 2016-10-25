package design;

import java.util.*;

public class MiniTwitterPullModel {

	private HashMap<Integer, HashSet<Integer>> relationship;
	private HashMap<Integer, LinkedList<Tweet>> userTweets;
	
	class TweetNode implements Comparable<TweetNode> {
		
		Tweet tweet;
		ListIterator<Tweet> iter;
		TweetNode(Tweet tweet, ListIterator<Tweet> iter) {
			this.tweet = tweet;
			this.iter = iter;
		}
		
		public int compareTo(TweetNode t1) {
			if (t1 == null)
				return -1;
			return t1.tweet.id - this.tweet.id;
		}
	}
	
	public MiniTwitterPullModel() {
		relationship = new HashMap<Integer, HashSet<Integer>>();
		userTweets = new HashMap<Integer, LinkedList<Tweet>>();
	}
	
	public Tweet postTweet(int user_id, String tweet_text) {
		Tweet tweet = Tweet.create(user_id, tweet_text);
		if (!userTweets.containsKey(user_id))
			userTweets.put(user_id, new LinkedList<Tweet>());
		
		LinkedList<Tweet> myTweets = userTweets.get(user_id);
		myTweets.addFirst(tweet);;
		return tweet;
	}
	
	public void follow(int follower, int followee) {
		if (follower == followee)
			return;
		
		if (!relationship.containsKey(follower))
			relationship.put(follower, new HashSet<Integer>());
		
		relationship.get(follower).add(followee);
	}
	
	public void unfollow(int follower, int followee) {
		
		if (relationship.containsKey(follower))
            relationship.get(follower).remove(followee);
	}
	
	public LinkedList<Tweet> getTimeline(int user_id) {
		if (!userTweets.containsKey(user_id))
			userTweets.put(user_id, new LinkedList<Tweet>());
		
		LinkedList<Tweet> myTweets = userTweets.get(user_id);
		return myTweets.size() > 10 ? (LinkedList<Tweet>) myTweets.subList(0, 10) : myTweets;
	}
	
	public List<Tweet> getNewsFeed(int user_id) {
		
		List<TweetNode> allFolloweesTweets = new ArrayList<TweetNode>();
		ListIterator<Tweet> myTweets = getTimeline(user_id).listIterator();
		if (myTweets.hasNext())
		    allFolloweesTweets.add(new TweetNode(myTweets.next(), myTweets));
		
		if (relationship.containsKey(user_id)) {
			for (Integer followee : relationship.get(user_id)){
				LinkedList<Tweet> followeeTweets = getTimeline(followee);
				if (followeeTweets.size() > 0) {
					ListIterator<Tweet> iterat = followeeTweets.listIterator();
					allFolloweesTweets.add(new TweetNode(iterat.next(), iterat));
				}
			}
		}
		
		return getTop10Feeds(allFolloweesTweets);
	}
	
	private List<Tweet> getTop10Feeds(List<TweetNode> tweetLists) {
		
		List<Tweet> sortedFeeds = new ArrayList<Tweet>();
		PriorityQueue<TweetNode> recentFeed = new PriorityQueue<TweetNode>();
		for (TweetNode node : tweetLists) {
			recentFeed.add(node);
		}
		int i = 0;
		while (!recentFeed.isEmpty() && i < 10) {
			TweetNode node = recentFeed.poll();
			sortedFeeds.add(node.tweet);
			i ++;
			if (node.iter.hasNext()) {
				node.tweet = node.iter.next();
				recentFeed.add(node);
			}
		}
		return sortedFeeds;
	}
	
	public static void main(String[] args) {
		MiniTwitterPullModel miniTwitter = new MiniTwitterPullModel();
    	
    	System.out.println(miniTwitter.postTweet(1, "LintCode is Good!!!"));
    	System.out.println(miniTwitter.getNewsFeed(1));
    	System.out.println(miniTwitter.getTimeline(1));
    	miniTwitter.follow(2, 1);
    	System.out.println(miniTwitter.getNewsFeed(2));
    	miniTwitter.unfollow(2, 1);
    	System.out.println(miniTwitter.getNewsFeed(2));
    }
}
