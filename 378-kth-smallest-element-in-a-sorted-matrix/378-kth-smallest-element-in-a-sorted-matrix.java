class Solution {
    public int kthSmallest(int[][]arr, int k) {
        int lo = arr[0][0];
        int hi = arr[arr.length-1][arr[0].length-1];
        while(lo < hi) {
            int mid = lo + (hi-lo)/2;
            int temp = 0;
            int j = arr[0].length-1;
            for(int i=0; i<arr.length; i++) {
                while(j >= 0 && arr[i][j] > mid) j--;
                temp += j+1;
            }
            if(temp < k) {
                lo = mid+1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}