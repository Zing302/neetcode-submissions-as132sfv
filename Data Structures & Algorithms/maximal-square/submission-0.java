class Solution {
    public int maximalSquare(char[][] matrix) {
        int maxHeight=0;
        int m=matrix.length;
        int n=matrix[0].length;
        int[] dp=new int[n+1];
        for(int r=m-1;r >=0; r--){
            int bottom=0;
            int right=0;
            int diagonal=0;
            for(int c=n-1;c>=0;c--){
                right=dp[c+1];
                diagonal=bottom;
                bottom=dp[c];
                if(matrix[r][c]=='1'){
                    dp[c]=1+Math.min(diagonal,Math.min(right,bottom));
                    maxHeight=Math.max(maxHeight,dp[c]);
                }
                else if(matrix[r][c]=='0'){
                    dp[c]=0;
                }
            }
        }
        return maxHeight*maxHeight;
    }
}