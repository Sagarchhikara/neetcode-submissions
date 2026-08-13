class TimeMap {
    class Pair {
        String val;
        int time;
        Pair(String val, int time) {
            this.val = val;
            this.time = time;
        }
    }

    HashMap<String, List<Pair>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)) map.put(key, new ArrayList<>());
        map.get(key).add(new Pair(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) return "";
        List<Pair> list = map.get(key);
        int ind = bs(timestamp, list);
        if(ind == -1) return "";
        return list.get(ind).val;
    }

    public int bs(int t, List<Pair> list) {
        int n = list.size();
        int l = 0;
        int r = n-1;
        int ans = -1;
        while(l <= r) {
          int mid = l + (r-l)/2;
          int tm = list.get(mid).time;
          if(tm <= t) {
            ans = mid;
            l = mid+1;
          }
          else {
            r = mid-1;
          }
        }
        return ans;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */