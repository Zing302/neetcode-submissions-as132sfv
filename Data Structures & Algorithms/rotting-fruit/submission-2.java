class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q=new LinkedList<>();
        int freshCount=0;
        for(int r=0;r<grid.length;r++){
            for(int c=0;c<grid[r].length;c++){
                if(grid[r][c]==2){
                    q.add(new int[]{r,c});
                }else if(grid[r][c]==1){
                    freshCount++;
                }
            }
        }
        if(freshCount==0){
            return 0;
        }
        int res=0;
        int[][] dir=new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        while(!q.isEmpty()){
            int size=q.size();
            boolean rotted=false;
            for(int i=0;i<size;i++){
                int[] fruit=q.remove();
                for(int[] d:dir){
                    int r=fruit[0] + d[0];
                    int c=fruit[1] + d[1];
                    if(r < 0 || c < 0 || r >= grid.length || c >=grid[0].length || grid[r][c]!=1){
                        continue;
                    }
                    if(grid[r][c]==1){
                        grid[r][c]=2;
                        q.add(new int[]{r,c});
                        freshCount--;
                        rotted=true;
                    }
                }
            }
            
            if(rotted){
                res++;
            }
        }
        if(freshCount!=0){
            return -1;
        }
        return res;
    }
}
