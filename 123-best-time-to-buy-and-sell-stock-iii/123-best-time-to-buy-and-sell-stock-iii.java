// Recursion
// TC = O(2^n)
// SC = O(n)
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
// O(m*n)
// SC = O(m*n) + O(n)
/*
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
*/

// Tabulation
// O(m*n)
// SC = O(m*n)
/*
class Solution {
    public int maxProfit(int[]arr) {
        int[][][]dp = new int[arr.length + 1][3][3];
        
        for(int i = arr.length-1; i>=0; i--){
            for(int idx = 1; idx >= 0; idx--){
                for(int deals = 1; deals >= 0; deals--){
                    if(idx == 0){
                        int buy = -arr[i] + dp[i+1][1][deals];
                        int ignore = dp[i+1][0][deals];
                        dp[i][idx][deals] = Math.max(buy, ignore);
                    }

                    else{
                        int sell = arr[i] + dp[i+1][0][deals+1];
                        int ignore = dp[i+1][1][deals];
                        dp[i][idx][deals] = Math.max(sell, ignore);
                    }
                }
            }
        }
        return dp[0][0][0];
    }
}
*/

// Spatial Optimization
class Solution {
    public int maxProfit(int[]arr) {
        int[][]prev = new int[3][3];
        
        for(int i = arr.length-1; i>=0; i--){
            int[][]curr = new int[3][3];
            for(int idx = 1; idx >= 0; idx--){
                for(int deals = 1; deals >= 0; deals--){
                    if(idx == 0){
                        int buy = -arr[i] + prev[1][deals];
                        int ignore = prev[0][deals];
                        curr[idx][deals] = Math.max(buy, ignore);
                    }

                    else{
                        int sell = arr[i] + prev[0][deals+1];
                        int ignore = prev[1][deals];
                        curr[idx][deals] = Math.max(sell, ignore);
                    }
                }
            }
            prev = curr;
        }
        return prev[0][0];
    }
}