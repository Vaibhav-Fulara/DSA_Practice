class Solution {
    public int minEatingSpeed(int[] arr, int h) {
        int lo = 1, hi = 1000000007;
        
        while(lo <= hi){
            int mid = lo + (hi-lo)/2;
            int count = 0;
            
            for(int i:arr) count += (i+mid-1)/mid;
            
            if(count <= h) hi = mid-1;
            else lo = mid + 1;
        }
        return lo;
    }
}