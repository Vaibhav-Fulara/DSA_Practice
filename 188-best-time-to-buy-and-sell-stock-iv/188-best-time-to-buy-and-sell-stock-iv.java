/*
class Solution {
    public int maxProfit(int k, int[]arr) {
        int[][][]dp = new int[arr.length][2][k];
        for(int[][]ar1:dp) for(int[]ar2:ar1) Arrays.fill(ar2, -1);
        return stockexchange(arr, 0, 0, 0, dp, k);
    }
    
    public int stockexchange(int[]arr, int i, int idx, int deals, int[][][]dp, int k){
        if(i == arr.length || deals == k) return 0;
        
        if(dp[i][idx][deals] != -1) return dp[i][idx][deals];
        
        if(idx == 0){
            int buy = -arr[i] + stockexchange(arr, i+1, 1, deals, dp, k);
            int ignore = stockexchange(arr, i+1, 0, deals, dp, k);
            return dp[i][idx][deals] = Math.max(buy, ignore);
        }
        
        else{
            int sell = arr[i] + stockexchange(arr, i+1, 0, deals+1, dp, k);
            int ignore = stockexchange(arr, i+1, 1, deals, dp, k);
            return dp[i][idx][deals] = Math.max(sell, ignore);
        }
    }
}
*/

class Solution {
    public int maxProfit(int k, int[]arr) {
        int[][][]dp = new int[arr.length + 1][3][k+1];
        
        for(int i = arr.length-1; i>=0; i--){
            for(int idx = 1; idx >= 0; idx--){
                for(int deals = k-1; deals >= 0; deals--){
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