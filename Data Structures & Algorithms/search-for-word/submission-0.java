class Solution {
    boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        visited=new boolean[board.length][board[0].length];
        Boolean res=false;
        for(int r=0;r<board.length;r++){
            for(int c=0;c<board[0].length;c++){
                if(res){
                    return true;
                }
                if(board[r][c]==word.charAt(0)){
                    res = exist(board,word,r,c,0);
                }
            }
        }
        return res;
    }

    private boolean exist(char[][] board, String word,int row, int col, int ind){
        //base case
        if(ind >= word.length()){
            return true;
        }
        if(row >= board.length || col >= board[0].length || row < 0 || col < 0 || board[row][col] != word.charAt(ind) || visited[row][col]){
            return false;
        }
        //add
        visited[row][col]=true;

        //explore
        Boolean res = exist(board,word,row+1,col,ind+1) || exist(board,word,row,col+1,ind+1) || exist(board,word,row-1,col,ind+1) || exist(board,word,row,col-1,ind+1);

        //Backtrack
        visited[row][col]=false;

        return res;
    }
}
