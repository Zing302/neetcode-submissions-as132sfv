class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> has = new HashMap<>();
        for(String str:strs){
            int[] charList=new int[26];
            for(int i=0;i<str.length();i++){
                charList[str.charAt(i)-'a']++;
            }
            has.putIfAbsent(Arrays.toString(charList),new ArrayList<>());
            has.get(Arrays.toString(charList)).add(str);
        }
        return new ArrayList<List<String>>(has.values());
    }
}
