class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> q=new LinkedList<>();
        for(int r=0;r<grid.length;r++){
            for(int c=0;c<grid[0].length;c++){
                if(grid[r][c]==0){
                    q.add(new int[]{r,c});
                }
            }
        }
        int[][] dir=new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        while(!q.isEmpty()){
            int[] t=q.remove();
            for(int[] d:dir){
                int r=d[0]+t[0];
                int c=d[1]+t[1];
                if(r<0 || c<0 || r>=grid.length || c>=grid[r].length || grid[r][c]==-1){
                    continue;
                }
                if(grid[r][c]==Integer.MAX_VALUE){
                    grid[r][c]=1+grid[t[0]][t[1]];
                    q.add(new int[]{r,c});
                }
            }
        }
    }
}
