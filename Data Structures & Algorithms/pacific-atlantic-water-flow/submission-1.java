class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        boolean[][] pacific=new boolean[heights.length][heights[0].length];
        boolean[][] atlantic=new boolean[heights.length][heights[0].length];
        for(int row=0;row<heights.length;row++){
            dfs(row,0,heights[row][0],pacific, heights);
            dfs(heights.length-row-1,heights[0].length-1,heights[heights.length-row-1][heights[0].length-1],atlantic,heights);
        }
        for(int cols=0;cols<heights[0].length;cols++){
            dfs(0,cols,heights[0][cols],pacific, heights);
            dfs(heights.length-1,heights[0].length-cols-1,heights[heights.length-1][heights[0].length-cols-1],atlantic,heights);
        }
        List<List<Integer>> res=new ArrayList<>();
        for(int r=0;r<heights.length;r++){
            for(int c=0;c<heights[0].length;c++){
                if(pacific[r][c] && atlantic[r][c]){
                    res.add(Arrays.asList(r,c));
                }
            }
        }
        return res;
    }
    public void dfs(int row,int col,int prevHeight,boolean[][] ocean, int[][] heights){
        if((row >= heights.length || row < 0 || col >= heights[0].length || col < 0) || ocean[row][col] || heights[row][col] < prevHeight){
            return;
        }
        ocean[row][col]=true;
        dfs(row+1,col,heights[row][col],ocean,heights);
        dfs(row-1,col,heights[row][col],ocean,heights);
        dfs(row,col+1,heights[row][col],ocean,heights);
        dfs(row,col-1,heights[row][col],ocean,heights);
    }
}
