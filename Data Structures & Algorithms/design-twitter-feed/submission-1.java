class Twitter {
    HashMap<Integer,Set<Integer>> following;
    HashMap<Integer,Deque<int[]>> tweetLog;
    int time;
    public Twitter() {
        tweetLog=new HashMap<>();
        following=new HashMap<Integer,Set<Integer>>();
        time=0;
    }
    
    public void postTweet(int userId, int tweetId) {
        if(!tweetLog.containsKey(userId)){
            tweetLog.put(userId, new ArrayDeque<>());
        }
        tweetLog.get(userId).offerFirst(new int[]{time,tweetId,userId});
        time++;
        if(tweetLog.get(userId).size() > 10){
            tweetLog.get(userId).pollLast();
        }
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> getRel=new PriorityQueue<>((a,b)->b[0]-a[0]);
        Deque<int[]> feed=tweetLog.get(userId);
        if(tweetLog.containsKey(userId)){
            for(int[] i:feed){
                getRel.add(i);
            }
        }
        if(following.containsKey(userId)){
            Set<Integer> follow=following.get(userId);
            for(int f:follow){
                if(tweetLog.containsKey(f)){
                    feed=tweetLog.get(f);
                    for(int[] i:feed){
                        getRel.add(i);
                    }
                }
            }
        }
        ArrayList<Integer> res=new ArrayList<>();
        while(!getRel.isEmpty() && res.size() < 10){
            int[] rem=getRel.remove();
            res.add(rem[1]);
        }
        return res;
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
