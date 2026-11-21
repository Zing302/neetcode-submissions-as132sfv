class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<int[]>[] edges = new ArrayList[n+1];
        for(int i = 1; i <= n ; i++){
            edges[i] = new ArrayList<>();
        }
        for(int i = 0; i < times.length ; i++){
            int u = times[i][0];
            int v = times[i][1];
            int time = times[i][2];
            edges[u].add(new int[]{v, time});
        }
        Set<Integer> visited = new HashSet<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> (a[1]-b[1]));
        int cost = 0;
        pq.offer(new int[]{k,0});
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int node = curr[0];
            int weight = curr[1];
            if(visited.contains(node)){
                continue;
            }
            visited.add(node);
            cost = weight;
            for(int[] nei : edges[node]){
                if(!visited.contains(nei[0])){
                    pq.offer(new int[]{nei[0], nei[1] + weight});
                }  
            }
        }
        if(visited.size() == n){
            return cost;
        }else{
            return -1;
        }
    }
}
