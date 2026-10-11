class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max=0;
        for(int i:piles){
            max=Math.max(max,i);
        }
        int min=1;
        while(min <= max){
            int mid=min+(max-min)/2;
            long hour=0;
            for(int p:piles){
                hour+=p/mid;
                if(p % mid > 0){
                    hour++;
                }
            }
            if(hour > h){
                min=mid+1;
            }else{
                max=mid-1;
            }
        }
        return min;
    }
}
