class TimeMap {
    class TimePair{
        int time;
        String val;
        public TimePair(int time, String val){
            this.time = time;
            this.val = val;
        }
    }
    private Map<String,ArrayList<TimePair>> timeMap;
    public TimeMap() {
        timeMap = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if(!timeMap.containsKey(key)){
            timeMap.put(key,new ArrayList<TimePair>());
        }
        TimePair tm = new TimePair(timestamp, value);
        timeMap.get(key).add(tm);
    }
    
    public String get(String key, int timestamp) {
        if(!timeMap.containsKey(key)){
            return "";
        }
        ArrayList<TimePair> timeArr = timeMap.get(key);
        int right = timeArr.size() - 1;
        int left = 0;
        String res = "";
        while(left <= right){
            int mid = left+(right - left)/2;
            if(timestamp == timeArr.get(mid).time){
                return timeArr.get(mid).val;
            }
            if(timestamp < timeArr.get(mid).time){
                right = mid - 1;
            }else{
                res = timeArr.get(mid).val;
                left = mid + 1;
            }
        }
        return res;

    }
}
