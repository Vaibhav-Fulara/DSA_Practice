class Solution {
    public int[] mostCompetitive(int[] arr, int k) {
        PriorityQueue<pair>pq = new PriorityQueue<>((a,b)->{
            if(a.val == b.val) return a.idx-b.idx;
            return a.val - b.val;
        });
        int i = 0;
        for(i=0; i <= arr.length-k; i++){
            pq.add(new pair(i, arr[i]));
        }
        int[]ans = new int[k];
        int prev = -1, j = 0;
        while(j != k){
            pair p = pq.remove();
            if(p.idx < prev) continue;
            ans[j++] = p.val;
            if(i != arr.length) pq.add(new pair(i, arr[i++]));
            prev = p.idx;
        }
        return ans;        
    }
    public class pair{
        int val;
        int idx;
        pair(int idx, int val){
            this.idx = idx;
            this.val = val;
        }
    }
}