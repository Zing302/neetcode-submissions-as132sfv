class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sumTotal=sum(nums);
        if((sumTotal+target)/2 > sumTotal || (sumTotal+target)/2 < 0 ){
            return 0;
        }
        int[] dp=new int[sumTotal+1];
        dp[0]=1;
        for(int num:nums){
            for(int i=sumTotal;i>=num;i--){
                if(dp[i-num] > 0){
                    dp[i]+=dp[i-num];
                }
            }
        }
        if((sumTotal+target)%2 != 0){
            return 0;
        }
        return dp[(sumTotal+target)/2];
    
    }

    private int sum(int[] nums){
        int total=0;
        for(int num:nums){
            total+=num;
        }
        return total;
    }
}
