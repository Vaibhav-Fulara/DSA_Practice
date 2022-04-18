class Solution {
    static int[][]dir = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    public int numIslands(char[][] grid) {
        int ans = 0;
        for(int i=0; i<grid.length; i++) for(int j=0; j<grid[0].length; j++) if(grid[i][j] == '1') {ans++; getIsland(grid, i, j);}
        return ans;
    }
    
    public void getIsland(char[][]grid, int sr, int sc){
        grid[sr][sc] = 0;
        for(int[]dirc : dir){
            int row = sr + dirc[0];
            int col = sc + dirc[1];
            if(row >= 0 && row < grid.length && col >= 0 && col < grid[0].length) if(grid[row][col]=='1') getIsland(grid, row, col);
        }
    }
}