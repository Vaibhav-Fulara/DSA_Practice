class Solution {
    public int minFallingPathSum(int[][]arr) {
        int n = arr.length, dr = n-1;
        int[][]dp = new int[n][n];
        
        for(int sr=dr; sr>=0; sr--){
            for(int sc=dr; sc>=0; sc--){
                if(sr == dr){
                    dp[sr][sc] = arr[sr][sc];
                    continue;
                } 
                int three = Integer.MAX_VALUE, two = Integer.MAX_VALUE, one = Integer.MAX_VALUE;
                
                one = dp[sr+1][sc];
                if(sc != dr) two = dp[sr+1][sc+1];
                if(sc != 0) three = dp[sr+1][sc-1];
                
                dp[sr][sc] = Math.min(three, Math.min(one,two)) + arr[sr][sc];
            }
        }
        int min = dp[0][0];
        for(int i=1; i<dp[0].length; i++) min = Math.min(min, dp[0][i]);
        return min;
    }
}