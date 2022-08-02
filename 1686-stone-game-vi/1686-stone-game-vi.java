class Solution {
    public int stoneGameVI(int[] alice, int[] bob) {
        int n = alice.length;
        int[]arr = new int[n];
        for(int i=0; i<n; i++) arr[i] = alice[i] + bob[i];
        boolean bool = true;
        
        PriorityQueue<pair>pq = new PriorityQueue<>((a,b) -> {
            return b.val - a.val;
        });
        
        for(int i=0; i<n; i++) {
            int val = arr[i];
            pq.add(new pair(i, val));
        }
        
        int a = 0, b = 0;
        while(!pq.isEmpty()) {
            if(bool) a += alice[pq.remove().idx];
            else b += bob[pq.remove().idx];
            bool = !bool;
        }
        if(a == b) return 0;
        return a > b ? 1:-1;
    }
    
    public class pair{
        int idx;
        int val;
        public pair(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }
    }
}