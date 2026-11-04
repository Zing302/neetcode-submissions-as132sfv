class KthLargest {
    private PriorityQueue<Integer> pq;
    private int k;
    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>((a,b)->a-b);
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
