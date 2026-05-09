class Solution {
    public int countSubstrings(String s) {
        int res=0;
        int size=s.length();
        boolean[][] dp=new boolean[size][size];
        for(int i=size-1;i>=0;i--){
            for(int j=i;j<size;j++){
                if(s.charAt(i)==s.charAt(j) && (j-i<=2 || dp[i+1][j-1])){
                    dp[i][j]=true;
                    res++;
                }
            }
        }
        return res;
    }
}
