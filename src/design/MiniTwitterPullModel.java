package design;

import java.util.*;

public class MiniTwitterPullModel {

	private HashMap<Integer, HashSet<Integer>> relationship;
	private HashMap<Integer, LinkedList<Tweet>> userTweets;
	
	class TweetNode implements Comparable<TweetNode> {
		
		
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
		
		if (!relationship.containsKey(followee))
			relationship.put(followee, new HashSet<Integer>());
		
		relationship.get(followee).add(follower);
	}
	
	public void unfollow(int follower, int followee) {
		
		relationship.get(followee).remove(follower);
	}
	
	public LinkedList<Tweet> getTimeline(int user_id) {
		if (!userTweets.containsKey(user_id))
			userTweets.put(user_id, new LinkedList<Tweet>());
		
		LinkedList<Tweet> myTweets = userTweets.get(user_id);
		return myTweets.size() > 10 ? (LinkedList<Tweet>) myTweets.subList(0, 10) : myTweets;
	}
	
	public List<Tweet> getNewsFeed(int user_id) {
		
		List<ListIterator<Tweet>> allFolloweesTweets = new ArrayList<ListIterator<Tweet>>();
		allFolloweesTweets.add(getTimeline(user_id).listIterator());
		if (relationship.containsKey(user_id)) {
			for (Integer followee : relationship.get(user_id)){
				LinkedList<Tweet> followeeTweets = getTimeline(followee);
				if (followeeTweets.size() > 0)
					allFolloweesTweets.add(followeeTweets.listIterator());
			}
		}
		
		return getTop10Feeds(allFolloweesTweets);
	}
	
	private List<Tweet> getTop10Feeds(List<ListIterator<Tweet>> tweetLists) {
		List<Tweet> sortedFeeds = new ArrayList<Tweet>();
		Comparator<Tweet> comparator = new Comparator<Tweet>() {
			public int compare(Tweet t1, Tweet t2) {
				if (t1 == null)
					return -1;
				else if (t2 == null)
					return 1;
				return t1.id - t2.id;
			}
		};
		
		PriorityQueue<Tweet> recentFeed = new PriorityQueue<Tweet>(comparator);
		for (ListIterator<Tweet> cur : tweetLists) {
			recentFeed.add(cur.next());
		}
		while (!recentFeed.isEmpty()) {
			recentFeed.poll();
			sortedFeeds.add()
		}
	}
}
