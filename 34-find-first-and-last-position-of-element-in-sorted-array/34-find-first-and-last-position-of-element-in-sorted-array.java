class Solution {
    public int[] searchRange(int[]arr, int tar) {
        int lo = 0, hi = arr.length-1;
        int[]ans = new int[]{-1,-1};
        while(lo <= hi){
            int mid = lo + (hi-lo)/2;
            if(arr[mid] > tar) hi = mid - 1;
            else if(arr[mid] < tar) lo = mid + 1;
            else{
                ans[0] = getLowest(arr, 0, mid, tar);
                ans[1] = getHighest(arr, mid, arr.length-1, tar);
                break;
            }
        }
        return ans;
    }
    public int getLowest(int[]arr, int lo, int hi, int tar){
        while(lo < hi){
            int mid = lo + (hi-lo)/2;
            if(arr[mid] > tar) hi = mid - 1;
            else if(arr[mid] < tar) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }
    public int getHighest(int[]arr, int lo, int hi, int tar){
        while(lo < hi){
            int mid = lo + (hi-lo)/2;
            if(arr[mid] > tar) hi = mid - 1;
            else if(arr[mid] < tar) lo = mid + 1;
            else {
                lo = mid;
                if(arr[hi] != tar) hi--;
                else break;
            }
        }
        return hi;
    }
}