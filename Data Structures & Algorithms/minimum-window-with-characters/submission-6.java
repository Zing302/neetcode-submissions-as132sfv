class Solution {
    public String minWindow(String s, String t) {
        if(t.length()==0 || s.length() < t.length()){
            return "";
        }
        Map<Character,Integer> tCount=new HashMap<Character,Integer>();
        Map<Character, Integer> window=new HashMap<Character,Integer>();
        for(Character c:t.toCharArray()){
            tCount.put(c,tCount.getOrDefault(c,0)+1);
        }
        int have=0;
        int need=tCount.size();
        int[] res=new int[]{-1,-1};
        int left=0;
        int resLen=Integer.MAX_VALUE;
        for(int right=0;right<s.length();right++){
            char c=s.charAt(right);
            window.put(c,window.getOrDefault(c,0)+1);
            if(tCount.containsKey(c) && window.get(c).equals(tCount.get(c))){
                have++;
            }
            while(have==need){
                if((right-left+1) < resLen){
                    res[0]=left;
                    res[1]=right;
                    resLen=(right-left+1);
                }
                char del=s.charAt(left);
                window.put(del,window.get(del)-1);
                if(tCount.containsKey(del) && window.get(del) < tCount.get(del)){
                    have--;
                }
                left++;
            }
        }
        if(res[0]<0 || res[1]<0){
            return "";
        }
        return s.substring(res[0],res[1]+1);
    }
}
