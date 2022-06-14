class Solution {
    public int maxProfit(int[]arr) {
        
        int[][]dp = new int[arr.length+1][2];
        
        for(int i = arr.length-1; i >= 0; i--){
            for(int curr = 1; curr >= 0; curr--){
                if(curr == 0){
                    int buy = -arr[i] +dp[i+1][1];
                    int ignore = dp[i+1][0];
                    dp[i][0] = Math.max(buy, ignore);
                }
                else{
                    int sell = arr[i] + dp[i+1][0];
                    int keep = dp[i+1][1];
                    dp[i][1] = Math.max(sell, keep);
                }
            }
        }
        return dp[0][0];
    }
}