// Spatially Optimized Solution

// class Solution {
//     public int minFallingPathSum(int[][]arr) {
//         int n = arr.length, dr = n-1;        
//         int[]prev = new int[n];
        
//         for(int sr=dr; sr>=0; sr--){
//             int[]curr = new int[n];
//             for(int sc=dr; sc>=0; sc--){
//                 if(sr == dr){
//                     curr[sc] = arr[sr][sc];
//                     continue;
//                 } 
//                 int three = Integer.MAX_VALUE, two = Integer.MAX_VALUE, one = Integer.MAX_VALUE;
                
//                 one = prev[sc];
//                 if(sc != dr) two = prev[sc+1];
//                 if(sc != 0) three = prev[sc-1];
                
//                 curr[sc] = Math.min(three, Math.min(one,two)) + arr[sr][sc];
//             }
//             prev = curr;
//         }
//         int min = prev[0];
//         for(int i=1; i<prev.length; i++) min = Math.min(min, prev[i]);
//         return min;
//     }
// }

// Tabulation Solution

// class Solution {
//     public int minFallingPathSum(int[][]arr) {
//         int n = arr.length, dr = n-1;
//         int[][]dp = new int[n][n];
        
//         for(int sr=dr; sr>=0; sr--){
//             for(int sc=dr; sc>=0; sc--){
//                 if(sr == dr){
//                     dp[sr][sc] = arr[sr][sc];
//                     continue;
//                 } 
//                 int three = Integer.MAX_VALUE, two = Integer.MAX_VALUE, one = Integer.MAX_VALUE;
                
//                 one = dp[sr+1][sc];
//                 if(sc != dr) two = dp[sr+1][sc+1];
//                 if(sc != 0) three = dp[sr+1][sc-1];
                
//                 dp[sr][sc] = Math.min(three, Math.min(one,two)) + arr[sr][sc];
//             }
//         }
//         int min = dp[0][0];
//         for(int i=1; i<dp[0].length; i++) min = Math.min(min, dp[0][i]);
//         return min;
//     }
// }

// Memoisation Solution

class Solution {
    public int minFallingPathSum(int[][]arr) {
        int n = arr.length, dr = n-1;
        int[][]dp = new int[n][n];
        for(int[]val:dp) Arrays.fill(val,-1);
        
        int min = Integer.MAX_VALUE;
        for(int i=0; i<dp[0].length; i++) {
            getPath(0,i,n-1,arr,dp);
            min = Math.min(min, dp[0][i]);
        }
        return min;
    }
    public int getPath(int sr, int sc, int dr, int[][]arr, int[][]dp){
        if(sr == dr) return dp[sr][sc] = arr[sr][sc];
        
        if(dp[sr][sc] != -1) return dp[sr][sc];
        
        int three = Integer.MAX_VALUE, two = Integer.MAX_VALUE;
        int one = getPath(sr+1, sc, dr, arr, dp);
        if(sc != dr) two = getPath(sr+1, sc+1, dr, arr, dp);
        if(sc != 0) three = getPath(sr+1, sc-1, dr, arr, dp);

        return dp[sr][sc] = Math.min(three, Math.min(one,two)) + arr[sr][sc];
    }
}