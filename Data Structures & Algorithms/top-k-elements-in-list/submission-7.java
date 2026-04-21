class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> cnt=new HashMap<>();
        int[] freq=new int[k];
        for(int i=0;i<nums.length;i++){
            cnt.put(nums[i],cnt.getOrDefault(nums[i],0)+1);
        }
        PriorityQueue<int[]> q=new PriorityQueue<int[]>((a,b) -> (a[0]-b[0]));
        for(int key:cnt.keySet()){
            q.offer(new int[]{cnt.get(key),key});
            if(q.size()>k){
                q.poll();
            }
        }
        for(int i=0;i<k;i++){
            freq[i]=q.poll()[1];
        }
        return freq;
    }
}
