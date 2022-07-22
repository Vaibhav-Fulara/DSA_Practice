class Solution {
    public int numSubarrayBoundedMax(int[]arr, int left, int right) {
        int strt = -1;
        int end = -1;
        int ans = 0;
        for(int i=0; i<arr.length; i++) {
            if(arr[i] > right) {
                strt = end = i;
            } else if (arr[i] >= left && arr[i] <= right) {
                end = i;
            }
            ans += end-strt;
        }
        return ans;
    }
}