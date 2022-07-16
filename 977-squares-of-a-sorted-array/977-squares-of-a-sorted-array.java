class Solution {
    public int[] sortedSquares(int[] arr) {
        int lo = 0, hi = arr.length-1;
        int tar = -1;
        
        while(lo < hi) {
            int mid = lo + (hi-lo)/2;
            if(arr[mid] > 0) {
                hi = mid-1;
            } else if (arr[mid] < 0) {
                lo = mid + 1;
            } else {
                tar = mid;
                break;
            }
        }
        if(tar == -1) tar = lo;
        
        int i=0, j=0;
        if(arr[tar] >= 0) {j = tar; i=tar-1;}
        else {j = tar+1; i = tar;}
        
        int[]ans = new int[arr.length];
        
        int k=0;
        while(i >= 0 || j < arr.length){
            if(i == -1 || j < arr.length && (int)Math.abs(arr[i]) > (int)Math.abs(arr[j])) {
                ans[k++] = arr[j] * arr[j++];
            } else {
                ans[k++] = arr[i] * arr[i--];
            }
        }
        
        return ans;
    }
}