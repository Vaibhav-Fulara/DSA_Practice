class Solution {
    public boolean searchMatrix(int[][] matrix, int tar) {
        int lr = matrix.length-1;
        int lc = matrix[0].length-1;
        for(int i=0; i<=lr; i++){
            int[]arr = matrix[i];
            if(arr[0]>tar) return false;
            if(arr[0]==tar || arr[lc]==tar) return true;
            if(arr[lc]>tar){
                boolean isPresent = binSearch(0, lc, arr, tar);
                if(isPresent) return true;
            }
        }
        return false;
    }
    
    public boolean binSearch(int lo, int hi, int[]arr, int tar){
        while(lo<=hi){
            int mid = lo + (hi-lo)/2;
            if(arr[mid] == tar) return true;
            if(arr[mid]<tar) lo = mid+1;
            else hi = mid-1;
        }
        return false;
    }
}