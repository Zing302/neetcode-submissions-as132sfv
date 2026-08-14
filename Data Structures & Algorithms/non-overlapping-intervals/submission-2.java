class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->Integer.compare(a[0],b[0]));
        int cnt=0;
        int prev=intervals[0][1];
        for(int i=1;i<intervals.length;i++){
            int[] arr=intervals[i];
            if(prev>arr[0]){
                cnt++;
                prev=Math.min(prev,arr[1]);
                continue;
            }
            prev=arr[1];
        }
        return cnt;
    }
}
