class Solution {
    public int search(int[] arr, int tar) {
        int lo = 0, hi = arr.length-1;
        while(lo <= hi) {
            int mid = lo + (hi-lo)/2;
            if(arr[mid] == tar) return mid;
            else if (arr[mid] >= arr[lo]){
                if (arr[mid] > tar && arr[lo] <= tar) hi = mid-1;
                else lo = mid+1;
            }
            else {
                if(arr[hi] >= tar && arr[mid] < tar) lo = mid+1;
                else hi = mid-1;
            }
        }
        return -1;
    }
}