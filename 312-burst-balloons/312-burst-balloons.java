class Solution {
    public int maxCoins(int[] nums) {
        int[]arr = new int[nums.length + 2];
        int i = 0;
        arr[i++] = 1;
        for(int val:nums) arr[i++] = val;
        arr[i] = 1;
        int[][]dp = new int[arr.length][arr.length];
        for(int[]a:dp) Arrays.fill(a,-1);
        return solve(arr, 1, arr.length-2, dp);
    }
    public int solve(int[]arr, int lo, int hi, int[][]dp) {
        if(lo > hi) return 0;
        if(lo == hi) return arr[lo-1]*arr[lo]*arr[lo+1];
        if(dp[lo][hi] != -1) return dp[lo][hi];
        int max = Integer.MIN_VALUE;
        for(int idx=lo; idx<=hi; idx++) {
            max = Math.max(max, arr[lo-1]*arr[idx]*arr[hi+1] + solve(arr, lo, idx-1, dp) + solve(arr, idx+1, hi, dp));
        }
        return dp[lo][hi] = max;
    }
}