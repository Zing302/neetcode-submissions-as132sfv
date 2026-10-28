class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] price = new int[n];
        Arrays.fill(price, Integer.MAX_VALUE);
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0; i < flights.length; i++){
            int[] flight=flights[i];
            adj.get(flight[0]).add(new int[]{flight[1],flight[2]});
        }
        price[src] = 0;
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{src,0,0});
        while(!q.isEmpty()){
            int[] curr=q.remove();
            int source = curr[0];
            int cost = curr[2];
            ArrayList<int[]> dest=adj.get(source);
            int stops=curr[1];
            if(stops > k){
                continue;
            }
            for(int[] nei:dest){
                int p = nei[1] + cost;
                int newScr = nei[0];
                if(price[newScr] > p){
                    price[newScr] = p;
                    q.add(new int[]{newScr, stops+1, p});
                }
            }
        }
        if(price[dst] == Integer.MAX_VALUE){
            return -1;
        }
        return price[dst];
    }
}
