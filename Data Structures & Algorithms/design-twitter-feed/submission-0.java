class Twitter {
    HashMap<Integer,Set<Integer>> following;
    PriorityQueue<int[]> tweetLog;
    int time;
    public Twitter() {
        tweetLog=new PriorityQueue<>((a,b)->b[0]-a[0]);
        following=new HashMap<Integer,Set<Integer>>();
        time=0;
    }
    
    public void postTweet(int userId, int tweetId) {
        tweetLog.add(new int[]{time,tweetId,userId});
        time++;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> mostRecent=new ArrayList<>();
        PriorityQueue<int[]> temp=new PriorityQueue<>((a,b)->b[0]-a[0]);
        while(!tweetLog.isEmpty()){
            int[] rem=tweetLog.remove();
            if((rem[2]==userId || (following.containsKey(userId) && following.get(userId).contains(rem[2]))) && mostRecent.size() < 10){
                mostRecent.add(rem[1]);
            }
            temp.add(rem);
        }
        tweetLog=temp;
        return mostRecent;
    }
    
    public void follow(int followerId, int followeeId) {
        if(!following.containsKey(followerId)){
            following.put(followerId,new HashSet<>());
        }
        following.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(!following.containsKey(followerId)){
            return;
        }
        following.get(followerId).remove(followeeId);
    }
}
