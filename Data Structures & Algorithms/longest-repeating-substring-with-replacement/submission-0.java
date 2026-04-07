class Solution {
    public int characterReplacement(String s, int k) {
        if(s.length()==1){
            return s.length();
        }
        int rem=k;
        int left=0;
        int max=0;
        Map<Character,Integer> mp=new HashMap<>();
        for(int right=0;right<s.length();right++){
            mp.put(s.charAt(right),1+mp.getOrDefault(s.charAt(right),0));
            while(right-left+1-Collections.max(mp.values())>k){
                mp.put(s.charAt(left),mp.get(s.charAt(left))-1);
                left++;
            }
            max=Math.max(max,right-left+1);
        }
        return max;
    }
}
