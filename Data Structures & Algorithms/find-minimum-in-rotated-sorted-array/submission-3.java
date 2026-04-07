class Solution {
    public int findMin(int[] nums) {
        int right=nums.length-1;
        int left=0;
        
        while(left<right){
            int midInd=left+(right-left)/2;
                // if middle>right, the right half is accending order
                if(nums[midInd]>nums[right]){
                left=midInd+1;
            }else{
                right=midInd;
            }
        }
        return nums[left];
    }
}
