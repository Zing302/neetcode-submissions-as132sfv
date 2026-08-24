class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length > (n-1)){
            return false;
        }
        List<List<Integer>> nei=new ArrayList<>();
        for(int i=0;i<n;i++){
            nei.add(new ArrayList<Integer>());
        }
        for(int[] edge:edges){
            nei.get(edge[0]).add(edge[1]);
            nei.get(edge[1]).add(edge[0]);
        }
        HashSet<Integer> visited=new HashSet<Integer>();
        if(!dfs(0,-1,visited,nei)){
            return false;
        }
        return visited.size()==n;
    }

    private boolean dfs(int node,int prev,HashSet<Integer> visited,List<List<Integer>> nei){
        if(visited.contains(node)){
            return false;
        }
        visited.add(node);
        for(int nb:nei.get(node)){
            if(nb==prev){
                continue;
            }
             if(!dfs(nb,node,visited,nei)){
                return false;
             }
        }

        return true;

    }
}
