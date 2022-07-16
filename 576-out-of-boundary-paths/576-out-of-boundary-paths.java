class Solution {
    int big = (int)(1e9+7);
    public int findPaths(int m, int n, int maxMove, int strtr, int strtc) {
        int[][]dirs = {{-1,0}, {0,-1}, {1,0}, {0,1}};
        Long[][][]dp = new Long[m][n][maxMove+1];
        
        return (int)(solve(m, n, maxMove, strtr, strtc, dirs, dp) % big);
    }
    public long solve(int r, int c, int moves, int i, int j, int[][]dirs, Long[][][]dp) {
        if(i < 0 || j < 0 || i >= r || j >= c) return 1;
        if(moves == 0) return 0;
        
        if(dp[i][j][moves] != null) return dp[i][j][moves];
        
        long ans = 0;
        for(int[]dir:dirs) {
            int x = i+dir[0];
            int y = j+dir[1];
            long val = solve(r, c, moves-1, x, y, dirs, dp);
            val %= big;
            // System.out.println(ans + val);
            ans += val;
            ans %= big;
        }
        return dp[i][j][moves] = ans;
    }
}