// O(n*logk)
// TLE
/*
class Solution {
    public int[] maxSlidingWindow(int[] arr, int k) {
        Map<Integer, pair>hm = new HashMap<>();
        
        PriorityQueue<pair>pq = new PriorityQueue<>((a,b) -> b.val - a.val);
        
        int[]ans = new int[arr.length - k + 1];
        int i=0, j = k-1;
        
        for(int x=0; x<k-1; x++) {
            pair p = new pair(x, arr[x]);
            pq.add(p);
            hm.put(x, p);
        }
        
        while(i < ans.length) {
            pair temp = new pair(j, arr[j]);
            pq.add(temp);
            hm.put(j++, temp);
            
            pair p = pq.peek();
            ans[i] = p.val;
            
            pq.remove(hm.get(i));
            hm.remove(i++);
        }
        
        return ans;
    }
    
    public class pair {
        int idx;
        int val;
        public pair (int idx, int val){
            this.idx = idx;
            this.val = val;
        }
    }
}
*/

class Solution {
    public int[] maxSlidingWindow(int[] arr, int k) {
        ArrayDeque<pair>qu = new ArrayDeque<>();
        
        int[]ans = new int[arr.length - k + 1];
        int i=0, j = k-1;
        
        for(int x=0; x<k-1; x++) {
            while(!qu.isEmpty() && qu.getFirst().val < arr[x]) qu.removeFirst();
            qu.addFirst(new pair(x,arr[x]));
        }
        
        while(i < ans.length) {
            while(!qu.isEmpty() && qu.getFirst().val < arr[j]) qu.removeFirst();
            qu.addFirst(new pair(j, arr[j++]));
            // System.out.println(qu.size());
            // System.out.println(qu.getLast());
            ans[i++] = qu.getLast().val;
            // System.out.println(qu.getLast().idx + " " + (i-1) + " " + (qu.getLast().idx - i + 1));
            if(qu.getLast().idx - i + 1 == 0) qu.removeLast();
            // System.out.println(qu.size());
        }
        
        return ans;
    }
    
    public class pair {
        int idx;
        int val;
        public pair (int idx, int val){
            this.idx = idx;
            this.val = val;
        }
    }
}

