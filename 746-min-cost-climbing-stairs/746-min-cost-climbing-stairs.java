class Solution {
    public int minCostClimbingStairs(int[] arr) {
        int n=arr.length;
        int[]dp = new int[n];
        for(int i=n-1; i>=0; i--){
            if(i==n-1 || i==n-2) dp[i]=arr[i];
            else dp[i] = Math.min(dp[i+1],dp[i+2])+arr[i];
        }
        return Math.min(dp[0],dp[1]);
    }
}