class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                break;
            }
            int left=i+1;
            int right=nums.length-1;
            while(left<right){
                int sum=nums[i]+nums[left]+nums[right];
                if(sum<0){
                    left++;
                }else if(sum>0){
                    right--;
                }else{
                    if(!list.contains(Arrays.asList(nums[i],nums[left],nums[right])))
                        list.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    left++;
                    right--;
                }
            }
        }
        return list;
    }
}
