class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backtracking(res,new ArrayList<>(),nums,0);
        return res;
    }

    public void backtracking(List<List<Integer>> res, ArrayList<Integer> curr, int[] nums, int iter){
        res.add(new ArrayList<>(curr));
        if(iter >= nums.length){
            return;
        }
        for(int i = iter;i<nums.length;i++){
            if(i != 0 && iter < i && nums[i-1] == nums[i]){
                continue;
            }
            curr.add(nums[i]);
            backtracking(res,curr,nums,i+1);
            curr.remove(curr.size()-1);
        }
    }
}
