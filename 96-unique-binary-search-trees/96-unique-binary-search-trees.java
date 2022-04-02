class Solution {
    public int numTrees(int n) {
        int[]dp = new int[n+1];
        return getAns(n,dp);
    }
    public int getAns(int val, int[]dp){
        if(val==0 || val==1) return dp[val] = 1;
        if(dp[val]!=0) return dp[val];
        int ans = 0;
        for(int i=0; i<val; i++)  ans += (getAns(i, dp) * getAns(val-1-i, dp));
        return dp[val] = ans;
    }
}