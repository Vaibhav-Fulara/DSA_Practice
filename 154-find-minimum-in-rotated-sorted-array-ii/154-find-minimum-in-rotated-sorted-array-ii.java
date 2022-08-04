// O(n)
/*
class Solution {
    public int findMin(int[]arr) {
        for(int i=1; i<arr.length; i++) {
            if(arr[i-1] > arr[i]) return arr[i];
        }
        return arr[0];
    }
}
*/

// O(logn)
class Solution {
    public int findMin(int[]arr) {
        int lo=0, hi=arr.length-1;
        while(hi > lo) {
            int mid = lo + (hi-lo)/2;
            if(arr[mid] > arr[hi]) lo = mid + 1;
            else if(arr[mid] < arr[lo]) {
                hi = mid;
                lo++;
            } else {
                hi--;
            }
        }
        return arr[lo];
    }
}