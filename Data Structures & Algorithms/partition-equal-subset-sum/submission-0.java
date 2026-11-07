class Solution {
    public boolean canPartition(int[] nums) {
        int total = 0;
        for(int n:nums){
            total+=n;
        }
        if(total%2 == 1 || nums.length < 2){
            return false;
        }
        int target = total / 2;
        boolean[] dp = new boolean[target+1];
        dp[0] = true;
        for(int num:nums){
            for(int i=target;i>=num;i--){
                if(dp[i - num]){
                    dp[i] = true;
                }
            }
        }
        return dp[target];
    }
}
