class Solution {
    public int getSum(int a, int b) {
        while(b!=0){
            int rem=(a&b)<<1;
            a=a^b;
            b=rem;
        }
        return a;
    }
}
