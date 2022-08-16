class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int n = arr.length;
        double lo = 0.0;
        double hi = 1.0;
        
        while(lo < hi) {
            double mid = lo + (hi-lo)/2;
            int p = 0;
            int q = 1;
            
            int curr = 0;
            int j=0;
            for(int i=0; i < n; i++) {
                while(j<n && arr[i] > mid * arr[j]) j++;
                if(j == n) break;
                curr += n-j;
                if(arr[i] * q > p * arr[j]) {
                    p = arr[i];
                    q = arr[j];
                }
            }
            if(curr < k) {
                lo = mid;
            } else if (curr > k){
                hi = mid;
            } else {
                return new int[]{p,q};
            }
        }
        return new int[]{-1,-1};
    }
}