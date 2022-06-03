class Solution {
    public int cherryPickup(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        
        int [][][]dp = new int[n][m][m];
        for(int [][]arr:dp) for(int[]a:arr) Arrays.fill(a,-1);
        return getMaxCherry(grid, 0, 0, m-1, dp);
    }
    public int getMaxCherry(int[][]grid, int i, int j1, int j2, int[][][]dp){
        if(i == grid.length-1){
            if(j1 == j2) return dp[i][j1][j2] = grid[i][j1];
            return dp[i][j1][j2] = grid[i][j1] + grid[i][j2];
        }
        
        if(dp[i][j1][j2] != -1) return dp[i][j1][j2];
        
        int max = Integer.MIN_VALUE, curr = 0;
        if(j1 == j2) curr += grid[i][j1];
        else curr += grid[i][j1] + grid[i][j2];
        
        for(int dj1 = -1; dj1 <= 1; dj1++){
            for(int dj2 = -1; dj2 <= 1; dj2++){
                int n1 = j1 + dj1, n2 = j2 + dj2;
                if(n1 >= 0 && n2 >= 0 && n1 < grid[0].length && n2 < grid[0].length){
                    max = Math.max(max, curr + getMaxCherry(grid, i+1, n1, n2, dp));
                }
            }
        }
        return dp[i][j1][j2] = max;
    }
}