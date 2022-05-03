class Solution {
    public int[][]dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int n = grid1.length;
        int m = grid1[0].length;
        // for(int i=0; i<n; i++) for(int j=0; j<m; j++) if(grid2[i][j]==1) if(grid1[i][j]!=1) grid2[i][j] = 0;
        int[][]arr = new int[n][m];
        int count = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid2[i][j]==1 && arr[i][j]==0){
                    boolean flag = traverse(i, j, arr, grid2, grid1);
                    if (flag) count++;
                }
            }
        }
        return count;
    }
    public boolean traverse(int i, int j, int[][]arr, int[][]grid, int[][]grid2){
        boolean bruh = grid2[i][j]==1;
        for(int[]dir:dirs){
            int x = i+dir[0];
            int y = j+dir[1];
            if(x>=0 && y>=0 && x<arr.length && y<arr[0].length && grid[x][y]==1 && arr[x][y]==0){
                arr[x][y] = 1;
                boolean bool = traverse(x,y,arr,grid, grid2);
                if(grid2[x][y]==0 || bool==false) bruh = false;
            }
        }
        return bruh;
    }
}