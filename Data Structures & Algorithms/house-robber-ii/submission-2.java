class Solution {
    public int rob(int[] nums) {
        if(nums.length<2){
            return nums[0];
        }
        return Math.max(dpHelp(nums,0,nums.length-1),dpHelp(nums,1,nums.length));
    }
    public int dpHelp(int[] nums, int start, int end){
        int len=end-start;
        if(len<2){
            return nums[start];
        }
        int[] dp=new int[len];
        dp[0]=nums[start];
        dp[1]=Math.max(nums[start],nums[start+1]);
        for(int i=2;i<len;i++){
            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[start+i]);
        }
        return dp[len-1];
    }
}
