class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));
        List<int[]> res=new ArrayList<>();
        res.add(intervals[0]);
        for(int i=1;i<intervals.length;i++){
            int[] interval=intervals[i];
            int[] lastInterval=res.get(res.size()-1);
            if(interval[0] > lastInterval[1]){
                res.add(interval);
            }else{
                lastInterval[1]=Math.max(interval[1],lastInterval[1]);
            }
        }
        return res.toArray(new int[res.size()][2]);
    }
}
