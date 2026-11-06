class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // row major approach
        int colLength =  matrix[0].length;
        int left = 0;
        int right = matrix.length * colLength -1;
        while(left <= right){
            int mid = left+(right-left)/2;
            int row = mid/colLength;
            int col = mid % colLength;
            if(matrix[row][col] == target){
                return true;
            }else if(matrix[row][col] < target){
                left = mid + 1;
            }else{
                right = mid -1;
            }
        }
        return false;
    }
}
