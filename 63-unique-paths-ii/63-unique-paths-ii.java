class Solution {
    public int uniquePathsWithObstacles(int[][] arr) {
        if(arr[0][0]==1) return 0;
        int[][]dirs = {{0,1}, {1,0}};
        int m = arr.length;
        int n = arr[0].length;
        int[][]dp = new int[m][n];
        return getUnique(0, 0, m-1, n-1, arr, dirs, dp);
    }
    public int getUnique(int sr, int sc, int dr, int dc, int[][]arr, int[][]dirs, int[][]dp){
        if(sr==dr && sc==dc) return dp[sr][sc] = 1;
        if(dp[sr][sc]!=0) return dp[sr][sc];
        else{
            int count = 0;
            for(int i=0; i<dirs.length; i++){
                int x = sr+dirs[i][0];
                int y = sc+dirs[i][1];
                if(isValid(x, y, dr, dc) && arr[x][y]!=1){
                    count += getUnique(x, y, dr, dc, arr, dirs, dp);
                }
            }
            return dp[sr][sc] = count;
        }
    }
    public boolean isValid(int x, int y, int m, int n){
        if(x<=m && x>=0 && y>=0 && y<=n) return true;
        return false;
    }
}
