class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res=new int[temperatures.length];
        for(int i=temperatures.length-2;i>=0;i--){
            int days=i+1;
            while(days<temperatures.length && temperatures[i] >= temperatures[days]){
                if(res[days]==0){
                    days=temperatures.length;
                    break;
                }
                days+=res[days];
            }
            if(days<temperatures.length){
                res[i]=days-i;
            }
        }
        return res;
    }
}
