class Solution {
    public int cherryPickup(int[][]arr) {
        int n = arr.length, m = arr[0].length;
        int[][][]dp = new int[n][m][m];
        for(int[][]nums:dp){
            for(int[]num:nums){
                Arrays.fill(num,-1);
            }
        }
        return getCherry(0, 0, m-1, m, n, arr, dp);
    }
    public int getCherry(int i, int j1, int j2, int m, int n, int[][]arr, int[][][]dp){
        if(i == n-1) {
            if(j1 == j2) return dp[i][j1][j2] = arr[i][j1];
            else return dp[i][j1][j2] = arr[i][j1] + arr[i][j2];
        }
        
        if(dp[i][j1][j2] != -1) return dp[i][j1][j2];
        
        int max = Integer.MIN_VALUE;
        
        int val = 0;
        if(j1 == j2) val+= arr[i][j1];
        else val+= arr[i][j1] + arr[i][j2];
        
        for(int dj1 = -1; dj1<=1; dj1++){
            for(int dj2 = -1; dj2<=1; dj2++){
                if(j1 + dj1 >= 0 && j1 + dj1 < m && j2 + dj2 >= 0 && j2 + dj2 < m)
                max = Math.max(max, val+getCherry(i+1, j1+dj1, j2+dj2, m, n, arr, dp));
            }
        }
        return dp[i][j1][j2] = max;
    }
}