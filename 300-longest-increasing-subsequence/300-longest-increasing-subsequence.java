class Solution {
    public int lengthOfLIS(int[] nums) {
        int n= nums.length;
        Integer[][]dp = new Integer[n][n];
        return getLIS(nums, 0, -1, dp);
    }
    public int getLIS(int[]arr, int i, int big, Integer[][]dp) {
        if(i == arr.length) return 0;
        if(big != -1 && dp[i][big] != null) return dp[i][big];
        int max = 0;
        if(big == -1 || arr[big] < arr[i]) {
            max = 1 + getLIS(arr, i+1, i, dp);
        }
        max = Math.max(max, getLIS(arr, i+1, big, dp));
        if(big == -1) return max;
        return dp[i][big] = max;
    }
}