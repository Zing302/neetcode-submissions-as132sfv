class Solution {
    public String longestPalindrome(String s) {
        int start=0;
        int len=0;
        int size=s.length();
        boolean[][] dp=new boolean[size][size];
        for(int i=size-1;i>=0;i--){
            for(int j=i;j<size;j++){
                if(s.charAt(i)==s.charAt(j) && (j-i<=2 || dp[i+1][j-1])){
                    dp[i][j]=true;
                    if(j-i+1>len){
                        start=i;
                        len=j-i+1;
                    }
                }
            }
        }
        return s.substring(start,start+len);
    }
}
