class Solution {
    public int[] findBall(int[][] grid) {
        int[]ans = new int[grid[0].length];
        
        int[][]dp = new int[grid.length+1][grid[0].length+1];
        for(int[]arr:dp) Arrays.fill(arr, -1);
        
        for(int j=0; j<grid[0].length; j++){
            ans[j] = traverse(grid, 0, j, dp);
        }
        return ans;
    }
    public int traverse(int[][]grid, int i, int j, int[][]dp){
        if(i == grid.length) return dp[i][j] = j;
        if((j == 0 && grid[i][j] == -1) || 
           (j == grid[0].length-1 && grid[i][j] == 1)) return dp[i][j] = -1;
        if((j != grid[0].length-1 && grid[i][j] == 1 && grid[i][j+1] == -1) || 
           (j != 0 && grid[i][j] == -1 && grid[i][j-1] == 1)) return dp[i][j] = -1;
        
        if(dp[i][j] != -1) return dp[i][j];
        
        if(grid[i][j] == 1) return dp[i][j] = traverse(grid, i+1, j+1, dp);
        if(grid[i][j] == -1) return dp[i][j] = traverse(grid, i+1, j-1, dp);
        return -1;
    }
}