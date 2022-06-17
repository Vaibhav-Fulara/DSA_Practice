class FreqStack {
    
    PriorityQueue<pair>pq;
    int i = 0;
    Map<Integer, Integer>hm = new HashMap<>();
    
    public FreqStack() {
        pq = new PriorityQueue<>((a,b)->{
            if(a.rep == b.rep) return b.entry-a.entry;
            return b.rep-a.rep;
        });
    }
    
    public void push(int val) {
        hm.put(val, hm.getOrDefault(val, 0)+1);
        pq.add(new pair(val, hm.get(val), i++));
    }
    
    public int pop() {
        pair p = pq.poll();
        hm.put(p.val, hm.get(p.val)-1);
        return p.val;
    }
    
    public class pair{
        int val;
        int rep;
        int entry;
        pair(int val, int rep, int entry){
            this.val = val;
            this.rep = rep;
            this.entry = entry;
        }
    }
}