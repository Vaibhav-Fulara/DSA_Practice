class Solution {
    public int fib(int n) {
        if(n==0) return 0;
        int[]dp = new int[n+1];
        return getFibo(n,dp);
    }
    public int getFibo(int n, int[]dp){
        if(n==1 || n==2) return dp[n] = 1;
        if(dp[n]!=0) return dp[n];
        return dp[n] = getFibo(n-1, dp) + getFibo(n-2, dp);
    }
}