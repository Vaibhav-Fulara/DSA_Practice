class Solution {
    public int cherryPickup(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        
        int [][][]dp = new int[n][m][m];
        
        for(int i=n-1; i >= 0; i--){
            for(int j1=0; j1<m; j1++){
                for(int j2 = 0; j2<m; j2++){

                    if(i == n-1){
                        if(j1 == j2) dp[i][j1][j2] = grid[i][j1];
                        else dp[i][j1][j2] = grid[i][j1] + grid[i][j2];
                        continue;
                    }

                    int max = Integer.MIN_VALUE, curr = 0;
                    if(j1 == j2) curr += grid[i][j1];
                    else curr += grid[i][j1] + grid[i][j2];

                    for(int dj1 = -1; dj1 <= 1; dj1++){
                        for(int dj2 = -1; dj2 <= 1; dj2++){
                            int n1 = j1 + dj1, n2 = j2 + dj2;
                            if(n1 >= 0 && n2 >= 0 && n1 < grid[0].length && n2 < grid[0].length){
                                max = Math.max(max, curr + dp[i+1][n1][n2]);
                            }
                        }
                    }
                    dp[i][j1][j2] = max;
                }
            }
        }
        return dp[0][0][m-1];
    }
}


