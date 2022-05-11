class Solution {
    public boolean searchMatrix(int[][]arr, int tar) {
        int lr = arr.length-1;
        int lc = arr[0].length-1;
        
        int lo = 0;
        int hi = lr;
        
        while(lo<hi){
            int mid = lo + (hi-lo)/2;
            if(arr[mid][lc] == tar) return true;
            if(arr[mid][lc] > tar) hi = mid;
            else lo = mid+1;
        }
        int row = hi;
        
        lo = 0;
        hi = lc;
        while(lo<=hi){
            int mid = lo + (hi-lo)/2;
            if(arr[row][mid] == tar) return true;
            if(arr[row][mid]<tar) lo = mid+1;
            else hi = mid-1;
        }
        return false;
    }
}