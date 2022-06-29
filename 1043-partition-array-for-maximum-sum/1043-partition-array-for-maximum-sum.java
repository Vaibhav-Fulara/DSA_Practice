class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[]dp = new int[arr.length];
        Arrays.fill(dp, -1);
        
        return solve(arr, 0, k, dp);
    }
    public int solve(int[]arr, int i, int k, int[]dp){
        if(i >= arr.length) return 0;
        
        if(dp[i] != -1) return dp[i];
        
        int max = Integer.MIN_VALUE, len = 0, maxi = Integer.MIN_VALUE;
        for(int j=i; j < Math.min(i+k, arr.length); j++){
            len++;
            maxi = Math.max(maxi, arr[j]);
            max = Math.max(max, len*maxi + solve(arr, j+1, k, dp));
        }
        return dp[i] = max;
    }
}