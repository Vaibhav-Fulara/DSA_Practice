class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<pair>pq = new PriorityQueue<>((a,b)->{
            if(a.diff == b.diff) return b.val-a.val;
            return b.diff - a.diff;
        });
        for(int val:arr){
            pq.add(new pair(Math.abs(x-val), val));
            if(pq.size()>k) pq.poll();
        }
        List<Integer>al = new ArrayList<>();
        while(pq.size()!=0) al.add(pq.poll().val);
        Collections.sort(al);
        return al;
    }
    
    public class pair{
        int diff;
        int val;
        pair(){}
        pair(int diff, int val){
            this.val = val;
            this.diff = diff;
        }
    }
}