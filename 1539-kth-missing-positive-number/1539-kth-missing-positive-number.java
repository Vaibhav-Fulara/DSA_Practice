class Solution {
    public int findKthPositive(int[] arr, int k) {
        int lo = 0, hi = arr.length;
        while(hi > lo) {
            int mid = lo + (hi-lo)/2;
            if(arr[mid] - mid >= k + 1) hi = mid;
            else lo = mid + 1;
        }
        return lo + k;
    }
}