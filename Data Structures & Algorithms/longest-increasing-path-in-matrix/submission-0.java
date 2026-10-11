class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        int max=0;
        int[][] dp=new int[m][n];
        int[][] dir=new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                max=Math.max(max,dfs(matrix,i,j,dir,dp,m,n));
            }
        }
        return max;
    }

    public int dfs(int[][] matrix,int i,int j,int[][] dir,int[][] dp,int m,int n){
    if(dp[i][j]!=0){
        return dp[i][j];
    }
    int max=1;
    for(int[] d:dir){
        int r=i+d[0];
        int c=j+d[1];
        if(r >= m || c >= n || r <0 || c<0){
            continue;
        }
        if(matrix[r][c] > matrix[i][j]){
            max=Math.max(max,1+dfs(matrix,r,c,dir,dp,m,n));
        }
    }
    dp[i][j]=max;
    return max;
    }
}
