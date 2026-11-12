class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(b[0]-a[0]));
        for(int i = 0; i < position.length; i++){
            pq.offer(new int[]{position[i],speed[i]});
        }
        Stack<Double> stk = new Stack<>();
        int res = 0;
        double prev = 0.0;
        while(!pq.isEmpty()){
            int[] ps = pq.poll();
            double time = ((double)target - ps[0])/ps[1];
            if(prev == 0 || time > prev){
                res++;
                prev = time;
            }
        }
        return res;
    }
}
