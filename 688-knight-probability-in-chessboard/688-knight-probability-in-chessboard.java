class Solution {
    int[][]dirs = new int[][]{{-2,-1},{-2,1},{2,-1},{2,1},{1,2},{1,-2},{-1,2},{-1,-2}};
    public double knightProbability(int n, int k, int r, int c) {
        if(k == 0) return 1d;
        
        double[][][]dp = new double[n][n][k+1];
        dp[r][c][0] = 1;
        
        for(int move=1; move<=k; move++) {
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    if(dp[i][j][move-1] != 0) {
                        for(int[]dir:dirs) {
                            int x = i+dir[0];
                            int y = j+dir[1];
                            if(x>=0 && y>=0 && x<n && y<n) {
                                dp[x][y][move] += (double) dp[i][j][move-1]/8;
                            }
                        }
                    }
                }
            }
        }
        
        double ans = 0d;
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                ans += dp[i][j][k];
            }
        }
        
        return ans;
    }
}