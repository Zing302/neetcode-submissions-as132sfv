class Solution {
    public int subarraySum(int[] nums, int k) {
        int res=0;
        HashMap<Integer, Integer> mp=new HashMap<>();
        int sum=0;
        mp.put(0,1);
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(mp.containsKey(sum-k)){
                res+=mp.get(sum-k);
            }
            mp.put(sum,mp.getOrDefault(sum,0)+1);
        } 
        
        return res;
    }
}