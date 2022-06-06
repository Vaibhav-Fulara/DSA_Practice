class Solution {
    public int splitArray(int[]arr, int m) {
        int lo = 0, hi = 0;
        for(int i:arr){
            lo = Math.max(lo, i);
            hi += i;
        }
        while(lo <= hi){
            int mid = lo + (hi-lo)/2;
            int min = 1, curr = 0;
            
            for(int no:arr){
                curr += no;
                if(curr > mid){
                    curr = no;
                    min ++;
                }
            }
            
            if(min <= m) hi = mid-1;
            else lo = mid+1;
        }
        return lo;
    }
}