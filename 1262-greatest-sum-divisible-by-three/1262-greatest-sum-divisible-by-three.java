class Solution {
    public int maxSumDivThree(int[] nums) {
        int[][]dp = new int[nums.length][3];
        for(int[]arr:dp) Arrays.fill(arr, -1);
        return getMaxSum(nums, 0, 0, dp);
    }
    
    public int getMaxSum(int[]arr, int i, int curr, int[][]dp){
        if(i == arr.length) {
            if(curr == 0) return 0;
            return Integer.MIN_VALUE;
        }
        if(dp[i][curr] != -1) return dp[i][curr];
        int ignore = getMaxSum(arr, i+1, curr, dp);
        int contain = arr[i] + getMaxSum(arr, i+1, (curr+arr[i]) % 3, dp);
        return dp[i][curr] = Math.max(ignore, contain);
    }
}