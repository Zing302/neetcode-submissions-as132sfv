class Solution {
    public int longestConsecutive(int[] nums) {
        int max=0;
        Set<Integer> set=new HashSet<>();
            for(int num:nums){
                set.add(num);
        }
        for(int n:nums){
            int cnt=0;
            int curr=n;
            while(set.contains(curr)){
                curr++;
                cnt++;
            }
            max=Math.max(max,cnt);
        }
    return max;
    }
}
