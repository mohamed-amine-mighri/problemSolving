class Twitter {

    private Map<Integer, Set<Integer>> followers;
    private Map<Integer, List<Tweet>> tweets;
    private int timestamp;

    class Tweet {
        int tweetId;
        int timestamp;

        public Tweet(int tweetId, int timestamp) {
            this.tweetId = tweetId;
            this.timestamp = timestamp;
        }
    }

    /** Initialize your data structure here. */
    public Twitter() {
        followers = new HashMap<>();
        tweets = new HashMap<>();
        timestamp = 0;
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if (!tweets.containsKey(userId)) {
            tweets.put(userId, new ArrayList<>());
        }
        tweets.get(userId).add(0, new Tweet(tweetId, timestamp++));
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> pq = new PriorityQueue<>((a, b) -> b.timestamp - a.timestamp);
        Set<Integer> followees = followers.getOrDefault(userId, new HashSet<>());
        followees.add(userId); // Include user's own tweets
        for (int followee : followees) {
            List<Tweet> userTweets = tweets.getOrDefault(followee, new ArrayList<>());
            for (Tweet tweet : userTweets) {
                pq.offer(tweet);
            }
        }
        List<Integer> feed = new ArrayList<>();
        while (!pq.isEmpty() && feed.size() < 10) {
            feed.add(pq.poll().tweetId);
        }
        return feed;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        followers.putIfAbsent(followerId, new HashSet<>());
        followers.get(followerId).add(followeeId);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        followers.putIfAbsent(followerId, new HashSet<>());
        followers.get(followerId).remove(followeeId);
    }
}


/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */