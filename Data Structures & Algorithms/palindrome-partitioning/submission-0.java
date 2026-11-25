class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> partition = new ArrayList<>();
        backtracking(0,res,partition,s);
        return res;
    }

    public void backtracking(int i, List<List<String>> res, List<String> partition, String s){
        if(i >= s.length()){
            res.add(new ArrayList<>(partition));
            return;
        }
        for(int j = i; j < s.length(); j++){
            if(isPalindrome(s,i,j)){
                partition.add(s.substring(i,j+1));
                backtracking(j + 1, res, partition, s);
                partition.remove(partition.size()-1);
            }
        }
    }

    public boolean isPalindrome(String s, int l, int r){
        while(l < r){
            if(s.charAt(l) != s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
