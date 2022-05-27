class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][]dp = new int[n][n];
        for(int[]val:dp) Arrays.fill(val, -1);
        return getMinPath(triangle,n-1,dp);
    }
    public int getMinPath(List<List<Integer>>al, int dr, int[][]dp){
        for(int sr=dr; sr>=0; sr--){
            for(int sc = sr; sc>=0; sc--){
                if(sr == dr || sc == dr){
                    dp[sr][sc] = al.get(sr).get(sc);
                    continue;
                } 

                int one = dp[sr+1][sc];
                int two = dp[sr+1][sc+1];

                dp[sr][sc] = Math.min(one, two) + al.get(sr).get(sc);
            }
        }
        return dp[0][0];
    }
}