class Solution {
    public boolean exist(char[][] board, String word) {
        for(int r=0;r<board.length;r++){
            for(int c=0;c<board[0].length;c++){
                if(board[r][c]==word.charAt(0)){
                    if(exist(board,word,r,c,0)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean exist(char[][] board, String word,int row, int col, int ind){
        //base case
        if(ind >= word.length()){
            return true;
        }
        if(row >= board.length || col >= board[0].length || row < 0 || col < 0 || board[row][col] != word.charAt(ind)){
            return false;
        }
        //add
        char temp=board[row][col];
        board[row][col]='#';

        //explore
        Boolean res = exist(board,word,row+1,col,ind+1) || exist(board,word,row,col+1,ind+1) || exist(board,word,row-1,col,ind+1) || exist(board,word,row,col-1,ind+1);

        //Backtrack
        board[row][col]=temp;

        return res;
    }
}
