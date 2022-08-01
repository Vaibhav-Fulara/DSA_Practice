// DP
/*
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
*/

// Combinatorics
class Solution {
    public int uniquePaths(int m, int n) {
        if (m <= 0 || n <= 0) return 0;
        if (m == 1 || n == 1) return 1;
        if (m < n) return uniquePaths(n, m);

        m--;
        n--;
        long paths = 1;
        for (int i = 1; i <= n; i++) {
            paths *= (m + i);
            paths /= i;
        }

        return (int) paths;
    }
}