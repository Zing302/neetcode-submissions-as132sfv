class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<Integer>());
        }
        for(int[] edge:edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        HashSet<Integer> visited=new HashSet<>();
        int cnt=0;
        for(int node=0;node<n;node++){
            if(!visited.contains(node)){
                dfs(node,visited,adj);
                cnt++;
            }
        }
        return cnt;
    }

    private void dfs(int node, HashSet<Integer> visited,List<List<Integer>> adj){
        if(visited.contains(node)){
            return;
        }
        visited.add(node);
        for(int nei:adj.get(node)){
            dfs(nei,visited,adj);
        }
    }
}
