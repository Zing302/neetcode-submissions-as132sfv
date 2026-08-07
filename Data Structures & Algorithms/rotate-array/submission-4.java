class Solution {
    public void rotate(int[] nums, int k) {
        int len=nums.length;
        k%=len;
        reverse(nums,0,len);
        reverse(nums,0,k);
        reverse(nums,k,len);
    }

    public void reverse(int[] nums, int start, int end){
        int mid=start+(end-start)/2;
        int ind=start;
        while(ind<mid){
            int temp=nums[ind];
            nums[ind]=nums[end-1-(ind-start)];
            nums[end-1-(ind-start)]=temp;
            ind++;
        }
    }
}