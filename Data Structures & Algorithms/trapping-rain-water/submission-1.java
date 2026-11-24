class Solution {
    public int trap(int[] height) {
        int leftMax = 0;
        int rightMax = 0;
        int left = 0;
        int right = height.length-1;
        int amount = 0;
        while(left < right){
            if(height[left] < height[right]){
                if(height[left] < leftMax){
                    amount+=leftMax-height[left];
                }
                leftMax = Math.max(height[left],leftMax);
                left++;
            }else{
                if(height[right] < rightMax){
                    amount+=rightMax-height[right];
                }
                rightMax = Math.max(height[right],rightMax);
                right--;
            }
        }
        return amount;
    }
}
