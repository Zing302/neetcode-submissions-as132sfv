class Solution {
    public void setZeroes(int[][] matrix) {
        boolean[] zeroRows=new boolean[matrix.length];
        boolean[] zeroCols=new boolean[matrix[0].length];
        for(int r=0;r<matrix.length;r++){
            for(int c=0;c<matrix[0].length;c++){
                if(matrix[r][c]==0){
                    zeroRows[r]=true;
                    zeroCols[c]=true;
                }
            }
        }
        for(int r=0;r<matrix.length;r++){
            if(zeroRows[r]){
                for(int c=0;c<matrix[0].length;c++){
                    matrix[r][c]=0;
                }
            }
        }
        for(int c=0;c<matrix[0].length;c++){
            if(zeroCols[c]){
                for(int r=0;r<matrix.length;r++){
                    matrix[r][c]=0;
                }
            }
        }
    }
}
