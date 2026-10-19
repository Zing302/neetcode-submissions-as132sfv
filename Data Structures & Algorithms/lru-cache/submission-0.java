class LRUCache {
    LinkedHashMap<Integer, Integer> cache;
    public LRUCache(int capacity) {
        cache=new LinkedHashMap<>(capacity, 0.75f, true){
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > capacity;
            }
        };
    }

    public int get(int key) {
        if(!cache.containsKey(key)){
            return -1;
        }
        return cache.get(key);
    }
    
    public void put(int key, int value) {
        cache.put(key,value);
    }
}
