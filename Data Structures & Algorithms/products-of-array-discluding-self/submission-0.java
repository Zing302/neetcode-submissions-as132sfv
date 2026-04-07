class Solution {
    public int[] productExceptSelf(int[] nums) {
        int size=nums.length;
        int[] product=new int[size];
        //product[0]=nums[1]*nums[2];
        //product[size-1]=nums[size-2]*nums[size-3];
        for(int i=0;i<size;i++){
            int right=size-1;
            int left=0;
            product[i]=1;
            while(right!=i){
                product[i]*=nums[right];
                right--;
            }
            while(left!=i){
                product[i]*=nums[left];
                left++;
            }
        }
        return product;
    }
}  
