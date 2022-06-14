// Memoization
/*
class Solution {
    public int maxProfit(int[]arr, int fee) {
        int[][]dp = new int[arr.length][2];
        for(int[]ar:dp) Arrays.fill(ar, -1);
        return getBestDeal(arr, 0, 0, dp, fee);
    }
    
    public int getBestDeal(int[]arr, int i, int curr, int[][]dp, int fee){
        if(i >= arr.length) return 0;
        if(dp[i][curr] != -1) return dp[i][curr];
        if(curr == 0){
            int buy = -arr[i] + getBestDeal(arr, i+1, 1, dp, fee);
            int ignore = getBestDeal(arr, i+1, 0, dp, fee);
            return dp[i][0] = Math.max(buy, ignore);
        }
        else{
            int sell = arr[i] - fee + getBestDeal(arr, i+1, 0, dp, fee);
            int keep = getBestDeal(arr, i+1, 1, dp, fee);
            return dp[i][1] = Math.max(sell, keep);
        }
    }
}
*/

// Tabulation
class Solution {
    public int maxProfit(int[]arr, int fee) {
        
        int[][]dp = new int[arr.length+2][2];
        
        for(int i = arr.length-1; i >= 0; i--){
            int buy = -arr[i] +dp[i+1][1];
            int ignore = dp[i+1][0];
            dp[i][0] = Math.max(buy, ignore);
            
            int sell = arr[i] - fee + dp[i+1][0];
            int keep = dp[i+1][1];
            dp[i][1] = Math.max(sell, keep);
        }
        return dp[0][0];
    }
}