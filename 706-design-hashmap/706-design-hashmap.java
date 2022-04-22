class MyHashMap {

    ArrayList<pair>al;
    
    public MyHashMap() {
        al = new ArrayList<>();
    }
    
    public void put(int key, int value) {
        for(pair p:al){
            if (p.key == key) {p.val = value; return;}
        }
        al.add (new pair(key, value));
    }
    
    public int get(int key) {
        for(pair p:al) if (p.key == key) return p.val;
        return -1;
    }
    
    public void remove(int key) {
        for(int i=0; i<al.size(); i++){
            if (al.get(i).key == key) {al.remove(i); return;}
        }
    }
    
    public class pair{
        int key;
        int val;
        pair(){}
        pair(int key, int val){
            this.key = key;
            this.val = val;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */