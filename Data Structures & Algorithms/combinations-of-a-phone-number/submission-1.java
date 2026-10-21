class Solution {
    Map<Character,String> mp=new HashMap<>();
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0){
            return new ArrayList<>();
        }
        mp.put('2',"abc");
        mp.put('3',"def");
        mp.put('4',"ghi");
        mp.put('5',"jkl");
        mp.put('6',"mno");
        mp.put('7',"pqrs");
        mp.put('8',"tuv");
        mp.put('9',"wxyz");
        ArrayList<String> res=new ArrayList<>();
        backtracking(res,new StringBuilder(),digits,0);
        return res;
    }

    public void backtracking(ArrayList<String> res, StringBuilder sb, String digits,int ind){
        if(ind==digits.length()){
            res.add(sb.toString());
            return;
        }
        String chs=mp.get(digits.charAt(ind));
        for(int i=0;i<chs.length();i++){
            sb.append(chs.charAt(i));
            backtracking(res,sb,digits,ind+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
