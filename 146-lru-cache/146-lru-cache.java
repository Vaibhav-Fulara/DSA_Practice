class LRUCache {
    LinkedHashMap<Integer, Integer>hm;
    int cap;
    public LRUCache(int capacity) {
        hm = new LinkedHashMap<>();
        cap = capacity;
    }
    
    public int get(int key) {
        if(hm.containsKey(key)) {int k = hm.remove(key); hm.put(key, k); return k;}
        return -1;
    }
    
    public void put(int key, int value) {
        if(hm.containsKey(key)) hm.remove(key);
        else if (hm.size()>cap-1){
            int oldest = hm.keySet().iterator().next();
            hm.remove(oldest);
        }
        hm.put(key, value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */