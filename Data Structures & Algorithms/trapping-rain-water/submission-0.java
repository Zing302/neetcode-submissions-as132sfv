class Solution {
    public int trap(int[] height) {
        int leftMax=0;
        int rightMax=0;
        int left=0;
        int right=height.length-1;
        int amount=0;
        while(left < right){
            if(height[left]<height[right]){
                if(height[left] >= leftMax){
                    leftMax=height[left];
                }else{
                    amount+=leftMax-height[left];
                }
                left++;
            }
            if(height[left]>=height[right]){
                if(height[right] >= rightMax){
                    rightMax=height[right];
                }else{
                    amount+=rightMax-height[right];
                }
                right--;
            }
        }
        return amount;
    }
}
