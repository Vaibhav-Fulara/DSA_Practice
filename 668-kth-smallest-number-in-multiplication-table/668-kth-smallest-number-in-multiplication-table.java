class Solution {
    public int findKthNumber(int m, int n, int k) {
        
        int lo = 1;
        int hi = m*n;
        
        while(lo < hi) {
            int mid = lo + (hi-lo)/2;
            int j = n-1;
            int curr = 0;
            for(int i=0; i<m; i++) {
                while(j >= 0 && (i+1)*(j+1) > mid) j--;
                curr += j+1;
            }
            if(curr < k) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }
}