class Solution {
    public int getMaxArea(int[][]grid, int i, int j){        
        if( i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == 1){
            grid[i][j] = 0;
            return 1 + getMaxArea(grid, i+1, j) + getMaxArea(grid, i-1, j) + getMaxArea(grid, i, j-1) + getMaxArea(grid, i, j+1);
        }
        return 0;        
    }
    
    public int maxAreaOfIsland(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        int maxArea = 0;
        for(int i=0; i<n; i++) for(int j=0; j<m; j++) if(arr[i][j] == 1) maxArea = Math.max(maxArea, getMaxArea(arr, i, j));
        return maxArea;
    }
}