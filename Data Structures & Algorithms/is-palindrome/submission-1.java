class Solution {
    public boolean isPalindrome(String s) {
        s=s.toLowerCase();
        int right=s.length()-1;
        int left=0;
        while(left<right){
            if(!isAlpha(s.charAt(left))){
                left++;
                continue;
            }
            if(!isAlpha(s.charAt(right))){
                right--;
                continue;
            }
            if(s.charAt(left)!=s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    public boolean isAlpha(char c){
        return (c>='0' && c<='9'|| c>='a' && c<='z');
    }
}
