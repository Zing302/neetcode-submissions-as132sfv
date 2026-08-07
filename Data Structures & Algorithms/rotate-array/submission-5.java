class Solution {
    public void rotate(int[] nums, int k) {
        int len=nums.length;
        if(len<k){
            k%=len;
        }   
        reverse(nums,0,len);
        reverse(nums,0,k);
        reverse(nums,k,len);
    }

    public void reverse(int[] nums, int start, int end){
        while(start<end){
            int temp=nums[start];
            nums[start]=nums[end-1];
            nums[end-1]=temp;
            start++;
            end--;
        }
    }
}