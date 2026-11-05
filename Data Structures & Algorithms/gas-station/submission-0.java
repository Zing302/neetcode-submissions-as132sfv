class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int totalCost = 0;
        for(int i=0;i<gas.length;i++){
            totalGas+=gas[i];
        }
        for(int i=0;i<gas.length;i++){
            totalCost+=cost[i];
        }
        if(totalGas < totalCost){
            return -1;
        }
        int res = 0;
        int diff = 0;
        for(int i=0;i<gas.length;i++){
            diff+=gas[i] - cost[i];
            if(diff < 0){
                res = i+1;
                diff = 0;
            }
        }
        return res;
    }
}
