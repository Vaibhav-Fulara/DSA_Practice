class Solution {
    static Integer[]dp = new Integer[100000+1];
    public boolean winnerSquareGame(int n) {
        return solve(n, 1) > 0;
    }
    public int solve(int n, int person) {
        if(n == 0) return -person;
        
        if(dp[n] != null) return dp[n] == 1 ? person:-person;
        
        for(int i=1; i*i <= n; i++) {
            if(solve(n - i*i, -person) == person) {
                dp[n] = 1;
                return person;
            }
        }
        
        dp[n] = -1;
        return -person;
    }
}