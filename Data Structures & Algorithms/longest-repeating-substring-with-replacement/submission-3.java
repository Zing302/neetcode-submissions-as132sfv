class Solution {
    public int characterReplacement(String s, int k) {
        int left=0;
        int max=0;
        int freq=0;
        Map<Character,Integer> mp=new HashMap<>();
        for(int right=0;right<s.length();right++){
            char c=s.charAt(right);
            mp.put(c,1+mp.getOrDefault(c,0));
            freq=Math.max(freq,mp.get(c));
            while(right-left+1-freq>k){
                mp.put(s.charAt(left),mp.get(s.charAt(left))-1);
                left++;
            }
            max=Math.max(max,right-left+1);
        }
        return max;
    }
}
