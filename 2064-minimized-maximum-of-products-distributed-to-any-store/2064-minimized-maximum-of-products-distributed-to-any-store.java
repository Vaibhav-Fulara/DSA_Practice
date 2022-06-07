class Solution {
    public int minimizedMaximum(int n, int[]arr) {
        int lo = 1, hi = 0;
        long sum = 0;
        for(int val:arr) {
            hi = Math.max(hi, val);
            sum += val;
        }
        if(sum <= n) return 1;
        
        while(lo <= hi){
            int mid = lo + (hi-lo)/2;
            int min = 0;
            
            for(int val:arr) min += Math.ceil(val*1.0/mid);
            
            if(min <= n) hi = mid-1;
            else lo = mid+1;
        }
        return lo;
    }
}