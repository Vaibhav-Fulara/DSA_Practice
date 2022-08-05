class Solution {
    public int combinationSum4(int[] nums, int target) {
        Integer[]dp = new Integer[target+1];
        return solve(nums, target, dp);
    }
    public int solve(int[]arr, int tar, Integer[]dp) {
        if(tar == 0) return dp[tar] = 1;
        if(dp[tar] != null) return dp[tar];
        int ans = 0;
        for(int i=0; i<arr.length; i++) if(tar >= arr[i]) ans += solve(arr, tar-arr[i], dp);
        return dp[tar] = ans;
    }
}