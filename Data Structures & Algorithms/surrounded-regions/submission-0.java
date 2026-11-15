class Solution {
    public void solve(char[][] board) {
        for(int r = 0; r< board.length; r++){
            if(board[r][0] == 'O'){
                    dfs(board,r,0);
            }
            if(board[r][board[r].length-1] == 'O'){
                dfs(board,r,board[r].length-1);
            }
            for(int c = 0; c< board[r].length; c++){
                if(board[0][c] == 'O'){
                    dfs(board,0,c);
                }
                if(board[board.length-1][c] == 'O'){
                    dfs(board,board.length-1,c);
                }
            }
        }
        for(int r = 0 ;r<board.length;r++){
            for(int c = 0; c< board[r].length; c++){
                if(board[r][c]=='O'){
                    board[r][c]='X';
                }else if(board[r][c]=='S'){
                    board[r][c]='O';
                }
            }
        }
    }

    private void dfs(char[][] board, int row, int col){
        if(row < 0 || col < 0 || row >= board.length || col >= board[0].length || board[row][col] != 'O'){
            return;
        }
        board[row][col] = 'S';
        dfs(board,row-1,col);
        dfs(board,row+1,col);
        dfs(board,row,col-1);
        dfs(board,row,col+1);

    }
}
