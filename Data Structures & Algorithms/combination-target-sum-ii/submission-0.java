class Solution {
    private List<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        Arrays.sort(candidates);
        backtracking(candidates, target, 0, 0,new ArrayList<Integer>());
        return res;
    }

    private void backtracking(int[] candidates, int target, int ind, int curr, ArrayList<Integer> candidate){
        if(curr == target){
            res.add(new ArrayList<>(candidate));
            return;
        }
        for(int i=ind;i<candidates.length;i++){
            if(i > ind && candidates[i] == candidates[i-1]){
                continue;
            }
            if(curr+candidates[i] > target){
                break;
            }
            candidate.add(candidates[i]);
            backtracking(candidates,target,i+1,curr+candidates[i],candidate);
            candidate.remove(candidate.size()-1);
        }
    }
}
