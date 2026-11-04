class KthLargest {
    PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->a-b);
    int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        for(int num:nums){
            pq.add(num);
            if(pq.size() > k){
                pq.remove();
            }
        }
    }
    
    public int add(int val) {
        pq.add(val);
        if(pq.size() > k){
            pq.remove();
        }
        return pq.peek();
    }
}
