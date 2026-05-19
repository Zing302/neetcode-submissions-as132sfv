class Solution {
    public int numDecodings(String s) {
        int num1=1;
        int num2=0;
        int res=0;
        int size=s.length();
        for(int i=size-1;i>=0;i--){
            if(s.charAt(i)=='0'){
                res=0;
            }else{
                res=num1;
                if(i+1<s.length() && (s.charAt(i)=='1' ||(s.charAt(i)=='2' && s.charAt(i+1)<'7'))){
                res+=num2;
                }
            }
            num2=num1;
            num1=res;
            res=0;
        }
        return num1;
    }
}
