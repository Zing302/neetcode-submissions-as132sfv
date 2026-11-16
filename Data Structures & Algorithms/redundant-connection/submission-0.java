class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length +1;
        int[] indegree = new int[n];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i < n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < n-1; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
            indegree[u]++;
            indegree[v]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i < n; i++){
            if(indegree[i] == 1){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int u = q.remove();
            indegree[u] --;
            ArrayList<Integer> nei = adj.get(u);
            for(int nb:nei){
                indegree[nb]--;
                if(indegree[nb] == 1){
                    q.add(nb);
                }
            }
        }
        for(int i = n-2; i >= 0; i--){
            int u = edges[i][0];
            int v = edges[i][1];
            if(indegree[u] > 1 && indegree[v] > 0){
                return new int[]{u,v};
            }
        }
        return new int[0];
    }
}
