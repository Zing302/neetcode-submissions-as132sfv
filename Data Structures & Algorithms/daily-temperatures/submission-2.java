class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int len=temperatures.length;
        int[] res=new int[len];
        for(int i=len-2;i>=0;i--){
            int day=i+1;
            while(day<len && temperatures[i] >= temperatures[day]){
                if(res[day]==0){
                    day=len;
                    break;
                }
                day+=res[day];
            }
            if(day<len){
               res[i]=day-i;
            }
            
        }
        return res;
    }
}
