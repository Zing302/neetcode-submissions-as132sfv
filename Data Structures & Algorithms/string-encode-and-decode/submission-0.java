class Solution {

    public String encode(List<String> strs) {
        StringBuilder res=new StringBuilder();
        for(String inside:strs){
            res.append(inside.length()+"#"+inside);
        }
        return res.toString();
    }

    public List<String> decode(String str) {
        List<String> dec=new ArrayList<String>();
        int i=0;
        while(i<str.length()){
            int j=i;
            while(str.charAt(j)!='#'){
                j++;
            }
            if(str.charAt(j)=='#'){
                int len=Integer.parseInt(str.substring(i,j));
                i=j+1+len;
                dec.add(str.substring(j+1,i));
            }
        }
        return dec;
    }
}
