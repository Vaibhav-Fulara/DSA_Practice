class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        
        if(obstacleGrid[0][0] == 1 || obstacleGrid[n-1][m-1] == 1) return 0;
        
        int[][]dp = new int[n][m];
        for(int[]arr:dp) Arrays.fill(arr,-1);
        int[][]dirs = {{0,1}, {1,0}};
        return traverse(obstacleGrid, 0, 0, n-1, m-1, dirs, dp);
    }
    public int traverse(int[][]arr, int sr, int sc, int dr, int dc, int[][]dirs, int[][]dp){
        if(sr == dr && sc == dc) return dp[sr][sc] = 1;
        if(dp[sr][sc] != -1) return dp[sr][sc];
        else{
            int ans = 0;
            arr[sr][sc] = 1;
            for(int[]dir:dirs){
                int x = sr + dir[0];
                int y = sc + dir[1];
                if(x <= dr && y <= dc && arr[x][y]!=1) ans += traverse(arr, x, y, dr, dc, dirs, dp);
            }
            arr[sr][sc] = 0;
            return dp[sr][sc] = ans;
        }
    }
}