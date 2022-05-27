class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length-1, n= grid[0].length-1;
        int[][] dirs = {{1,0}, {0,1}};
        int[][]dp = new int[m+1][n+1];
        for(int[]arr:dp) Arrays.fill(arr,-1);
        return getPathSum(grid, m, n, 0, 0, dirs, dp);
    }
    public int getPathSum(int[][]arr, int m, int n, int sr, int sc, int[][]dirs, int[][]dp){
        if(sr == m && sc == n) return dp[sr][sc] = arr[sr][sc];
        if(dp[sr][sc] != -1) return dp[sr][sc];
        int min = Integer.MAX_VALUE;
        for(int[]dir:dirs){
            int i = sr + dir[0];
            int j = sc + dir[1];
            if(i>=0 && j>=0 && i<=m && j<=n){
                int val = getPathSum(arr, m, n, i, j, dirs, dp);
                min = Math.min(min, val);
            } 
        }
        return dp[sr][sc] = min + arr[sr][sc];
    }
}