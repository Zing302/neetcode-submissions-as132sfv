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
        //int[] res=new int[]{-1,-1};
        int start=-1;
        int finish=-1;
        int left=0;
        int resLen=Integer.MAX_VALUE;
        for(int right=0;right<s.length();right++){
            char c=s.charAt(right);
            window.put(c,window.getOrDefault(c,0)+1);
            if(tCount.containsKey(c) && window.get(c).equals(tCount.get(c))){ //maps return integer object, so .equals
                have++;
            }
            while(have==need){
                if((right-left+1) < resLen){
                    start=left;
                    finish=right;
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
        if(start<0 || finish<0){
            return "";
        }
        return s.substring(start,finish+1);
    }
}
