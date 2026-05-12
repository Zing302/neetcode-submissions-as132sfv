class Solution {
    private HashMap<Integer,ArrayList<Integer>> mp;
    private HashSet<Integer> courses;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        mp=new HashMap<Integer,ArrayList<Integer>>();
        courses=new HashSet<Integer>();
        for(int i=0;i<numCourses;i++){
            mp.put(i,new ArrayList<Integer>());
        }
        for(int arr[]:prerequisites){
            if(mp.containsKey(arr[0])){
                mp.get(arr[0]).add(arr[1]);
            } 
        }
        for(int i=0;i<numCourses;i++){
            if(!dfs(i)){
                return false;
            }
        }
        return true;
    }

    public boolean dfs(int num){
        if(mp.get(num).isEmpty()){
            return true;
        }
        if(courses.contains(num)){
            return false;
        }
        courses.add(num);
        for(int n:mp.get(num)){
            if(!dfs(n)){
                return false;
            }
        }
        courses.remove(num);
        mp.put(num,new ArrayList<Integer>());
        return true;
    }
}
