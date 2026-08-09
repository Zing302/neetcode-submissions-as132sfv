class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> arr=new ArrayList<>();
        int left=0;
        int top=0;
        int right=matrix[0].length;
        int bottom=matrix.length;
        while(left<right && top<bottom){
            for(int l=left;l<right;l++){
                arr.add(matrix[top][l]);
            }
            top++;
            for(int t=top;t<bottom;t++){
                arr.add(matrix[t][right-1]);
            }
            right--;
            if(!(left<right && top < bottom)){
                break;
            }
            for(int r=right-1;r>=left;r--){
                arr.add(matrix[bottom-1][r]);
            }
            bottom--;
            for(int b=bottom-1;b>=top;b--){
                arr.add(matrix[b][left]);
            }
            left++;
        }
        return arr;
    }
}
