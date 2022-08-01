class Solution {
    public int uniquePaths(int m, int n) {
        Integer[][]dp = new Integer[m][n];
        return getPaths(0, 0, m-1, n-1, dp);
    }
    public int getPaths(int i, int j, int x, int y, Integer[][]dp) {
        if(i == x && j == y) return 1;
        if(dp[i][j] != null) return dp[i][j];
        int ans = 0;
        if(j < y) ans += getPaths(i, j+1, x, y, dp);
        if(i < x) ans += getPaths(i+1, j, x, y, dp);
        return dp[i][j] = ans;
    }
}