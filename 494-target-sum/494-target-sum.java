class Solution {
    public int findTargetSumWays(int[]arr, int target) {
        
        int sum = 0;
        for(int val:arr) sum += val;
        int k = sum - target;
        if(k < 0 || k%2 != 0) return 0;
        k /= 2;
        
        int[][]dp = new int[arr.length+1][k+1];
        for(int[]val:dp) Arrays.fill(val,-1);
        
        return helper(arr, k, 0, dp);
    }
    
    public int helper(int[]arr, int tar, int i, int[][]dp){
        if(tar < 0) return 0;
        if(i == arr.length){
            if(tar == 0) return dp[i][tar] = 1;
            return dp[i][tar] = 0;
        }
        
        if(dp[i][tar] != -1) return dp[i][tar];
        
        int count = 0;
        count += helper(arr, tar-arr[i], i+1, dp) + helper(arr, tar, i+1, dp);
        return dp[i][tar] = count;
    }
}