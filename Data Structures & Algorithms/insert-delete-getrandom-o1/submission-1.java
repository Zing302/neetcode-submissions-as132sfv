class RandomizedSet {
    Map<Integer,Integer> mp;
    ArrayList<Integer> list;
    public RandomizedSet() {
        mp=new HashMap<>();
        list=new ArrayList<>();
    }
    
    public boolean insert(int val) {
        if(!mp.containsKey(val)){
            list.add(val);
            mp.put(val,list.size()-1);
            return true;
        }
        return false;
        
    }
    
    public boolean remove(int val) {
        if(mp.containsKey(val)){
            int ind=mp.get(val);
            int last=list.get(list.size()-1);
            list.set(ind,last);
            mp.put(last,ind);
            list.remove(list.size()-1);
            mp.remove(val);
            return true;
        }
        return false;
    }
    
    public int getRandom() {
        int ind=(int)(Math.random() * list.size());
        return list.get(ind);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */