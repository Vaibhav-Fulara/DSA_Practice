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