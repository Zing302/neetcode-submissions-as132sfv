class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max=0;
        int right=0;
        int left=0;
        Set<Character> set=new HashSet<>();
        while(right!=s.length()){
            if(set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
            }else{
                set.add(s.charAt(right));
                right++;
                max=Math.max(max,right-left);
            }
        }
     return max;
    }
}

