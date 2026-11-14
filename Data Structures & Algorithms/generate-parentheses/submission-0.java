class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtracking(0,0,n,new StringBuilder(), res);
        return res;
    }

    private void backtracking(int start,int end,int n,StringBuilder perms, List<String> res){
        if(end == n){
            res.add(perms.toString());
            return;
        }
        if(start < n){
            perms.append("(");
            backtracking(start+1,end,n,perms,res);
            perms.deleteCharAt(perms.length()-1);
        }
        if(start > end){
            perms.append(")");
            backtracking(start,end+1,n,perms,res);
            perms.deleteCharAt(perms.length()-1);
        }
    }
}
