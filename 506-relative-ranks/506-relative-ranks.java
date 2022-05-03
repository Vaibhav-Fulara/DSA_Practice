class Solution {
    public String[] findRelativeRanks(int[]arr) {
        PriorityQueue<pair>pq = new PriorityQueue<>((a,b)->{return b.val-a.val;});
        String[]ans = new String[arr.length];
        int n = arr.length, j=0;
        for(int i=0; i<n; i++) {pq.add(new pair(j,arr[i])); j++;}
        j=1;
        while(pq.size()!=0){
            pair p = pq.remove();
            if(j==1) ans[p.idx] = "Gold Medal";
            else if (j==2) ans[p.idx] = "Silver Medal";
            else if (j==3) ans[p.idx] = "Bronze Medal";
            else ans[p.idx] = ""+j;
            j++;
        }
        return ans;
    }
    public class pair{
        int val;
        int idx;
        pair(){}
        pair(int idx, int val){
            this.idx = idx;
            this.val = val;
        }
    }
}