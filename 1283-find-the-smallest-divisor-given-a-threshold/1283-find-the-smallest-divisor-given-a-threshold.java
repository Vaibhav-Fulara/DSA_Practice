class Solution {
    public int smallestDivisor(int[]arr, int threshold) {
        int lo = 0, hi = (int)1e6;
        while(lo < hi) {
            long sum = 0;
            int mid = lo + (hi-lo)/2;
            for(int i=0; i<arr.length; i++) {
                sum += (Math.ceil((double)arr[i] / mid));
            }
            if(sum <= threshold) hi = mid;
            else lo = mid + 1;
        }
        return hi;
    }
}