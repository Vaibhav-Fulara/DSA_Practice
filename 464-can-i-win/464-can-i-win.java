class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (desiredTotal <= 0) return true;
        if (maxChoosableInteger * (maxChoosableInteger + 1) / 2 < desiredTotal) return false;
        int[] dp = new int[1 << maxChoosableInteger];
        return dfs(dp, 0, maxChoosableInteger, desiredTotal);
    }
    
    public boolean dfs(int[] dp, int curr, int max, int target) {
        if (target <= 0) return false;
        if (dp[curr] != 0) return dp[curr] == 1;
        boolean win = false;
        for (int i = 0; i < max; i++) {
            if ((curr & (1 << i)) == 0) {        // Not chosen yet
                win = win || !dfs(dp, curr | (1 << i), max, target - i - 1);
            }
        }
        dp[curr] = win ? 1 : -1;
        return win;
    }
}