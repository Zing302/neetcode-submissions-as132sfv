class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        backtracking(nums,res,subset,0);
        return res;
    }

    private void backtracking(int[] nums, List<List<Integer>> res,List<Integer> subset, int iter){
        res.add(new ArrayList<>(subset));
        if(iter >= nums.length){
            return;
        }
        for(int i=iter;i<nums.length;i++){
            subset.add(nums[i]);
            backtracking(nums,res,subset,i+1);
            subset.remove(subset.size()-1);
        }
    }
}
