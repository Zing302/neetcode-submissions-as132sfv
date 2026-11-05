class TimeMap {
    private Map<String,TreeMap<Integer,String>> timeMap;
    public TimeMap() {
        timeMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!timeMap.containsKey(key)){
            timeMap.put(key,new TreeMap<>());
        }
        TreeMap<Integer,String> mp = timeMap.get(key);
        mp.put(timestamp,value);
    }
    
    public String get(String key, int timestamp) {
        if(!timeMap.containsKey(key)){
            return "";
        }
        TreeMap<Integer,String> mp = timeMap.get(key);
        if(timestamp < mp.firstKey()){
            return "";
        }
        return mp.get(mp.floorKey(timestamp));

    }
}
