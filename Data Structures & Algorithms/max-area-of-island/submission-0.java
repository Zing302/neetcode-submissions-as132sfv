class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for(int r=0;r<grid.length;r++){
            for(int c=0;c<grid[r].length;c++){
                if(grid[r][c] == 1){
                    int cnt = dfs(grid,r,c);
                    max = Math.max(cnt,max);
                }
            }
        }
        return max;
    }

    private int dfs(int[][] grid, int row, int col){
        if(row < 0 || col < 0 || row >= grid.length || col >= grid[row].length || grid[row][col] == 0){
            return 0;
        }
        grid[row][col] = 0;
        return 1 + dfs(grid,row+1,col) + dfs(grid,row-1,col) + dfs(grid,row,col+1) + dfs(grid,row,col-1);
    }
}
