class Solution {
    public void setZeroes(int[][] matrix) {
        //boolean[] zeroRows=new boolean[matrix.length];
        //boolean[] zeroCols=new boolean[matrix[0].length];
        boolean zeroRow=false;
        boolean zeroCols=false;
        for(int r=0;r<matrix.length;r++){
            for(int c=0;c<matrix[0].length;c++){
                if(matrix[r][c]==0){
                    if(r==0){
                        zeroRow=true;
                    }
                    if(c==0){
                        zeroCols=true;
                    }
                    matrix[0][c]=0;
                    matrix[r][0]=0;
                }
            }
        }
        for(int r=1;r<matrix.length;r++){
            if(matrix[r][0]==0){
                for(int c=1;c<matrix[0].length;c++){
                    matrix[r][c]=0;
                }
            }
        }
        for(int c=1;c<matrix[0].length;c++){
            if(matrix[0][c]==0){
                for(int r=1;r<matrix.length;r++){
                    matrix[r][c]=0;
                }
            }
        }
        if(zeroRow){
            for(int c=0;c<matrix[0].length;c++){
                matrix[0][c]=0;
            }
        }
        if(zeroCols){
            for(int r=0;r<matrix.length;r++){
                matrix[r][0]=0;
            }
        }
    }
}
