class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        ArrayList<ArrayList<Integer>> nei = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            nei.add(new ArrayList<Integer>());
        }
        for(int i=0;i<prerequisites.length;i++){
            int prereq = prerequisites[i][1];
            int course = prerequisites[i][0];
            nei.get(prereq).add(course);
            inDegree[course]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(inDegree[i] == 0){
                q.add(i);
            }
        }
        int[] res = new int[numCourses];
        int i = 0;
        while(!q.isEmpty()){
            int p = q.remove();
            res[i] = p;
            i++;
            ArrayList<Integer> courses = nei.get(p);
            for(int c:courses){
                inDegree[c]--;
                if(inDegree[c] == 0){
                    q.add(c);
                }
            }
        }
        if(i != numCourses){
            return new int[0];
        }
        return res;
    }
}
