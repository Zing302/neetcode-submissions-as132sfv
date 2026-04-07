class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> l=new ArrayList<>();
        combinationSum(l,new ArrayList<Integer>(),nums,target,0);
        return l;
    }
    private void combinationSum(List<List<Integer>> l, List<Integer> temp, int[] nums, int target, int start){
        int currSum=sum(temp);
        if(currSum==target){
            l.add(new ArrayList<>(temp));
        }else if(currSum<target){
            for(int i=start;i<nums.length;i++){
                temp.add(nums[i]);
                combinationSum(l,temp,nums,target,i);
                temp.remove(temp.size()-1);
            }
        }
    }

    private int sum(List<Integer> nums){
        int sum=0;
        for(int i:nums){
            sum+=i;
        }
        return sum;
    }
}
