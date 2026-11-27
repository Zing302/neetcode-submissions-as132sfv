class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0){
            return false;
        }
        Map<Integer, Integer> mp = new HashMap<>();
        for(int h:hand){
            mp.put(h, mp.getOrDefault(h,0)+1);
        }
        for(int i:hand){
            int start = i;
            while(mp.containsKey(start -1) && mp.get(start-1) > 0){
                start --;
            }
            while(start <= i){
                while(mp.containsKey(start) && mp.get(start) > 0){
                    for(int j = start; j < start + groupSize; j++){
                        if(!mp.containsKey(j) || mp.get(j) == 0){
                            return false;
                        }
                        mp.put(j, mp.get(j) - 1);
                    }
                }
                start++;
            }
        }
        return true;
    }
}
