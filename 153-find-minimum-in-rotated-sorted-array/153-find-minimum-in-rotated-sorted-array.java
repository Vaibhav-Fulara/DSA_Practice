class Solution {
    public int findMin(int[]arr) {
        int lo=0, hi=arr.length-1;
        while(hi > lo) {
            int mid = lo + (hi-lo)/2;
            if(arr[mid] > arr[hi]) lo = mid + 1;
            else if(arr[mid] <= arr[hi]) hi = mid;
        }
        return arr[lo];
    }
}