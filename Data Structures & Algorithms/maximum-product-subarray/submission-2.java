class Solution {
    public int maxProduct(int[] nums) {
        int max=nums[0];
        int min=nums[0];
        int res=nums[0];
        for(int i=1;i<nums.length;i++){
            int curr=nums[i];
            
            int temp=max;
            max=Math.max(curr,Math.max(curr*max,curr*min));
            min=Math.min(curr,Math.min(curr*temp,curr*min));
            res=Math.max(Math.max(max,min),res);
        }
        return res;
    }
}
