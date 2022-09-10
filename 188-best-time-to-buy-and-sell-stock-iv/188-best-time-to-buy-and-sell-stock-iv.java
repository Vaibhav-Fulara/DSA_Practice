// Recurrence O(n**k) TLE
/*
class Solution {
    public int maxProfit(int k, int[] prices) {
        int[][]dp = new int[prices.length][k+1];
        for(int[]a:dp) Arrays.fill(a,-1);
        return solve(prices, k, 0, dp);
    }
    public int solve(int[]arr, int k, int idx, int[][]dp) {
        if(k == 0 || idx >= arr.length) return 0;
        if(dp[idx][k] != -1) return dp[idx][k];
        int max = Integer.MIN_VALUE;
        int curr = -arr[idx];
        for(int i = idx+1; i<arr.length; i++) {
            max = Math.max(max, curr + arr[i] + solve(arr, k-1, i+1, dp));
        }
        max = Math.max(max, solve(arr, k, idx+1, dp));
        return dp[idx][k] = max;
    }
}
*/
// Memoizatoin O(n*k) AC
/*
class Solution {
    public int maxProfit(int k, int[] prices) {
        int[][]dp = new int[prices.length][k+1];
        for(int[]a:dp) Arrays.fill(a,-1);
        return solve(prices, k, 0, dp);
    }
    public int solve(int[]arr, int k, int idx, int[][]dp) {
        if(k == 0 || idx >= arr.length) return 0;
        if(dp[idx][k] != -1) return dp[idx][k];
        int max = Integer.MIN_VALUE;
        int curr = -arr[idx];
        for(int i = idx+1; i<arr.length; i++) {
            max = Math.max(max, curr + arr[i] + solve(arr, k-1, i+1, dp));
        }
        max = Math.max(max, solve(arr, k, idx+1, dp));
        return dp[idx][k] = max;
    }
}
*/

// Tabulation
class Solution {
    public int maxProfit(int K, int[] arr) {
        int[][]dp = new int[arr.length+1][K+1];
        for(int k = 1; k <= K; k++) {
            for(int idx = arr.length-1; idx >= 0; idx--) {
                int max = Integer.MIN_VALUE;
                int curr = -arr[idx];
                for(int i = idx+1; i<arr.length; i++) {
                    max = Math.max(max, curr + arr[i] + dp[i+1][k-1]);
                }
                max = Math.max(max, dp[idx+1][k]);
                dp[idx][k] = max;
            }
        }
        return dp[0][K];
    }
}