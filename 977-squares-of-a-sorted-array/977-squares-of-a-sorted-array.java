class Solution {
    public int[] sortedSquares(int[]arr) {
        int[]ans = new int[arr.length];
        int lo = 0, hi = arr.length-1, k = hi;
        while(lo <= hi) {
            if(Math.abs(arr[lo]) > Math.abs(arr[hi])) {
                ans[k--] = arr[lo]*arr[lo++];
            } else {
                ans[k--] = arr[hi]*arr[hi--];
            }
        }
        return ans;
    }
}