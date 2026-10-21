class Solution {
    String[] charToDigits=new String[]{"","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0){
            return new ArrayList<>();
        }
        ArrayList<String> res=new ArrayList<>();
        res.add("");
        for(char digit:digits.toCharArray()){
            ArrayList<String> temp=new ArrayList<>();
            for(int i=0;i<res.size();i++){
                for(char c:charToDigits[digit-'1'].toCharArray()){
                    temp.add(res.get(i)+c);
                }
            }
            res=temp;
        }
        return res;
    }
}
