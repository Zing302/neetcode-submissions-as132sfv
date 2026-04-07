class Solution {
    public int[] productExceptSelf(int[] nums) {
        int size=nums.length;
        int[] product=new int[size];
        int num=1;
        product[0]=1;
        for(int i=1;i<size;i++){
            num*=nums[i-1];
            product[i]=num;
        }
        num=1;
        for(int i=size-2;i>=0;i--){
            num*=nums[i+1];
            product[i]*=num;
        }

        return product;
    }
}  
