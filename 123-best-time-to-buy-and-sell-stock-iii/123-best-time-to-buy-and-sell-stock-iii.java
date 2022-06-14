// Recursion
// TC = O(2^n)
// SC = O(1)
/*
class Solution {
    public int maxProfit(int[]arr) {
        return stockexchange(arr, 0, 0, 0);
    }
    public int stockexchange(int[]arr, int i, int idx, int deals){
        if(i == arr.length || deals == 2) return 0;
        
        if(idx == 0){
            int buy = -arr[i] + stockexchange(arr, i+1, 1, deals);
            int ignore = stockexchange(arr, i+1, 0, deals);
            return Math.max(buy, ignore);
        }
        
        else{
            int sell = arr[i] + stockexchange(arr, i+1, 0, deals+1);
            int ignore = stockexchange(arr, i+1, 1, deals);
            return Math.max(sell, ignore);
        }
    }
}
*/

// Memoization
class Solution {
    public int maxProfit(int[]arr) {
        int[][][]dp = new int[arr.length][2][2];
        
        for(int[][]ar1:dp) for(int[]ar2:ar1) Arrays.fill(ar2, -1);
        
        return stockexchange(arr, 0, 0, 0, dp);
    }
    public int stockexchange(int[]arr, int i, int idx, int deals, int[][][]dp){
        if(i == arr.length || deals == 2) return 0;
        
        if(dp[i][idx][deals] != -1) return dp[i][idx][deals];
        
        if(idx == 0){
            int buy = -arr[i] + stockexchange(arr, i+1, 1, deals, dp);
            int ignore = stockexchange(arr, i+1, 0, deals, dp);
            return dp[i][idx][deals] = Math.max(buy, ignore);
        }
        
        else{
            int sell = arr[i] + stockexchange(arr, i+1, 0, deals+1, dp);
            int ignore = stockexchange(arr, i+1, 1, deals, dp);
            return dp[i][idx][deals] = Math.max(sell, ignore);
        }
    }
}