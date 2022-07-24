class Solution {
    public boolean searchMatrix(int[][]arr, int tar) {
        for(int i=0; i<arr.length; i++) {
            if((arr[i][0] < tar) && (arr[i][arr[0].length-1] > tar)) {
                if(bin(arr[i], tar)) return true;
            } else if (arr[i][0] == tar || arr[i][arr[0].length-1] == tar) return true;
        }
        return false;
    }
    public boolean bin(int[]arr, int tar) {
        int lo = 0;
        int hi = arr.length;
        while(hi >= lo) {
            int mid = lo + (hi-lo)/2;
            if(arr[mid] > tar) {
                hi = mid-1;
            } else if (arr[mid] < tar) {
                lo = mid+1;
            } else {
                return true;
            }
        }
        return false;
    }
}