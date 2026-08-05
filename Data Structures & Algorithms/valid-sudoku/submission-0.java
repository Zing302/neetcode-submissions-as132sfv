class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0;i<board.length;i++){
            Set<Character> vaild=new HashSet<Character>();
            for(int j=0;j<9;j++){
                if(board[i][j]=='.'){
                    continue;
                }
                if(vaild.contains(board[i][j])){
                    return false;
                }else{
                    vaild.add(board[i][j]);
                }
            }
        }
        for(int i=0;i<board.length;i++){
            Set<Character> vaild=new HashSet<Character>();
            for(int j=0;j<9;j++){
                if(board[j][i]=='.'){
                    continue;
                }
                if(vaild.contains(board[j][i])){
                    return false;
                }else{
                    vaild.add(board[j][i]);
                }
            }
        }
        for(int square=0;square<9;square++){
            Set<Character> vaild=new HashSet<Character>();
            for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                int row=(square/3)*3+i;
                int col=(square%3)*3+j;
                if(board[row][col]=='.'){
                    continue;
                }
                if(vaild.contains(board[row][col])){
                    return false;
                }else{
                    vaild.add(board[row][col]);
                    }
                }
            }
        }
        return true;
    }
}
