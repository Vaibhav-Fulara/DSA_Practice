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