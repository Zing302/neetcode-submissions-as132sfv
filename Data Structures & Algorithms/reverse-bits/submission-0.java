class Solution {
    public int reverseBits(int n) {
        int res=0;
        for(int i=0;i<32;i++){
            int temp= n >> (31-i) & 1;
            res+=temp << (i);
        }
        return res;
    }
}
