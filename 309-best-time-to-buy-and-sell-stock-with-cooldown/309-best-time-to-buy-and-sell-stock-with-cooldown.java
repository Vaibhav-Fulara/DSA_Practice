// Memoisation
// TC = O(n)
// SC = O(n)
/*
class Solution {
    public int maxProfit(int[]arr) {
        int[][]dp = new int[arr.length][2];
        for(int[]ar:dp) Arrays.fill(ar, -1);
        return getBestDeal(arr, 0, 0, dp);
    }
    
    public int getBestDeal(int[]arr, int i, int curr, int[][]dp){
        if(i >= arr.length) return 0;
        if(dp[i][curr] != -1) return dp[i][curr];
        if(curr == 0){
            int buy = -arr[i] + getBestDeal(arr, i+1, 1, dp);
            int ignore = getBestDeal(arr, i+1, 0, dp);
            return dp[i][0] = Math.max(buy, ignore);
        }
        else{
            int sell = arr[i] + getBestDeal(arr, i+2, 0, dp);
            int keep = getBestDeal(arr, i+1, 1, dp);
            return dp[i][1] = Math.max(sell, keep);
        }
    }
}
*/

// Tabulation
class Solution {
    public int maxProfit(int[]arr) {
        
        int[][]dp = new int[arr.length+2][2];
        
        for(int i = arr.length-1; i >= 0; i--){
            for(int curr = 1; curr >= 0; curr--){
                if(curr == 0){
                    int buy = -arr[i] +dp[i+1][1];
                    int ignore = dp[i+1][0];
                    dp[i][0] = Math.max(buy, ignore);
                }
                else{
                    int sell = arr[i] + dp[i+2][0];
                    int keep = dp[i+1][1];
                    dp[i][1] = Math.max(sell, keep);
                }
            }
        }
        return dp[0][0];
    }
}