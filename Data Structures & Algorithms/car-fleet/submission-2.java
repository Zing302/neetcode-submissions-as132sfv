class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] ps = new int[n][2];
        for(int i=0;i<n;i++){
            ps[i]=new int[]{position[i],speed[i]};
        }
        Arrays.sort(ps,(a,b) -> (b[0]-a[0]));
        double prev = 0.0;
        int res = 0;
        for(int i=0;i<n;i++){
            int pos = ps[i][0];
            int spd = ps[i][1];
            double time = ((double)target - pos)/spd;
            if(prev == 0 || time > prev){
                prev = time;
                res++;
            }
        }
        return res;
    }
    
}