class Solution {
    public int minPathSum(int[][]arr) {
        int m = arr.length-1, n= arr[0].length-1;
        int[][] dirs = {{1,0}, {0,1}};
        int[][]dp = new int[m+1][n+1];
        for(int sr=m; sr>=0; sr--){
            for(int sc=n; sc>=0; sc--){
                if(sr == m && sc == n) {
                    dp[sr][sc] = arr[sr][sc];
                    continue;
                }
                int min = Integer.MAX_VALUE;
                for(int[]dir:dirs){
                    int i = sr + dir[0];
                    int j = sc + dir[1];
                    if(i>=0 && j>=0 && i<=m && j<=n){
                        int val = dp[i][j];
                        min = Math.min(min, val);
                    } 
                }
                dp[sr][sc] = min + arr[sr][sc];
            }
        }
        return dp[0][0];
    }
}