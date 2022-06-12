class Solution {
    public boolean search(int[]arr, int tar) {
        int lo = 0, hi = arr.length-1;
        while(lo <= hi){
            int mid = lo + (hi-lo)/2;
            if(arr[mid] == tar) return true;
            else if(arr[mid] > arr[lo]){
                if(arr[mid] > tar && arr[lo] <= tar) hi = mid-1;
                else lo = mid+1;
            }
            else if(arr[mid] < arr[lo]){
                if(tar > arr[mid] && tar <= arr[hi]) lo = mid+1;
                else hi = mid-1;
            }
            else lo++;
        }
        return false;
    }
}