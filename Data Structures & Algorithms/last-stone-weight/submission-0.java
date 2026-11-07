class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->(b-a));
        for(int stone:stones){
            pq.offer(stone);
        }
        while(pq.size() > 1){
            int one = pq.poll();
            int two = pq.poll();
            pq.offer(one-two);
        }
        return pq.poll();
    }
}
