class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][]dp = new int[n][n];
        for(int[]val:dp) Arrays.fill(val, -1);
        return getMinPath(triangle, 0, 0, n-1,dp);
    }
    public int getMinPath(List<List<Integer>>al, int sr, int sc, int dr, int[][]dp){
        if(sr == dr) return dp[sr][sc] = al.get(sr).get(sc);
        
        if(dp[sr][sc] != -1) return dp[sr][sc];
        
        int one = getMinPath(al, sr+1, sc, dr, dp);
        int two = getMinPath(al, sr+1, sc+1, dr, dp);
        
        return dp[sr][sc] = Math.min(one, two) + al.get(sr).get(sc);
    }
}