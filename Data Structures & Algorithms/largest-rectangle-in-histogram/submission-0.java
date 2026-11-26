class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<int[]> stk = new Stack<int[]>(); // width(i - comp), height
        int maxArea = 0;
        for(int i = 0; i < heights.length; i++){
            int ind = i;
            while(!stk.isEmpty() && stk.peek()[1] >= heights[i]){
                int[] comp = stk.pop();
                maxArea = Math.max(maxArea, (i - comp[0]) * comp[1]);
                ind = comp[0];
            }
            stk.push(new int[]{ind,heights[i]});
        }
        while(!stk.isEmpty()){
            int[] comp = stk.pop();
            maxArea = Math.max(maxArea, (heights.length - comp[0]) * comp[1]);
        }
        return maxArea;
    }
}
