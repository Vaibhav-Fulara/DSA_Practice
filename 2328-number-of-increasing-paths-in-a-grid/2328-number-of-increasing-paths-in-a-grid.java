class Solution{
    int[] dx = new int[]{1, -1, 0, 0};
    int[] dy = new int[]{0, 0, -1, 1};
    long res;
    int mod = 1000000007;
	
    public int countPaths(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        res = 0;
        long[][] memo = new long[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(memo[i][j] == 0) dfs(grid, memo, i, j);
            }
        }
        return (int) (1L * res % mod);
    }
    
    private long dfs(int[][] grid, long[][] memo, int x, int y){
        if(memo[x][y] != 0) return memo[x][y];
        long total = 1;
        for(int i = 0; i < 4; i++){
            int row = x + dx[i];
            int col = y + dy[i];
            if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length 
               || grid[x][y] >= grid[row][col]) continue;
            total += dfs(grid, memo, row, col) % mod;
        }
        memo[x][y] = total % mod;
        res += total % mod;
        return total % mod;
    }
}