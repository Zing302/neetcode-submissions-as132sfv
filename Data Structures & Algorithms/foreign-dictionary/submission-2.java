class Solution {
    public String foreignDictionary(String[] words) {
        if(words.length==1){
            return words[0];
        }
        HashMap<Character, Integer> inDegree=new HashMap<>();
        HashMap<Character, HashSet<Character>> adj=new HashMap<>();
        for(int i=0;i<words.length-1;i++){
            String left=words[i];
            String right=words[i+1];
            for(char c:left.toCharArray()){
                if(!adj.containsKey(c)){
                    adj.put(c,new HashSet<Character>());
                }
                inDegree.put(c,inDegree.getOrDefault(c,0));
            }
            for(char c:right.toCharArray()){
                if(!adj.containsKey(c)){
                    adj.put(c,new HashSet<Character>());
                }
                inDegree.put(c,inDegree.getOrDefault(c,0));
            }
            boolean suffixCheck=true;
            for(int j=0;j<Math.min(left.length(),right.length());j++){
                if(left.charAt(j) !=right.charAt(j)){
                    if(!adj.get(left.charAt(j)).contains(right.charAt(j))){
                        adj.get(left.charAt(j)).add(right.charAt(j));
                        inDegree.put(right.charAt(j),inDegree.get(right.charAt(j))+1);
                    }
                    suffixCheck=false;
                    break;
                }
            }
            if(suffixCheck && left.length() > right.length()){
                return "";
            }
        }
        Queue<Character> q=new LinkedList<>();
        for(Character key:inDegree.keySet()){
            if(inDegree.get(key)==0){
                q.add(key);
            }
        }
        StringBuilder res=new StringBuilder();
        while(!q.isEmpty()){
            char c=q.remove();
            HashSet<Character> nei=adj.get(c);
            for(Character n:nei){
                inDegree.put(n,inDegree.get(n)-1);
                if(inDegree.get(n) == 0){
                    q.add(n);
                }
            }
            res.append(c);
        }
        if(res.length() != inDegree.size()){
            return "";
        }
        return res.toString();
    }
}
