class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()) return false;
        int[][][]dp = new int[s1.length()+1][s2.length()+1][s3.length()+1];
        return getString(s1, s2, s3, 0, 0, 0, dp);
    }
    public boolean getString(String s1, String s2, String s3, int i, int j, int k, int[][][]dp){
        
        if(dp[i][j][k] != 0) return dp[i][j][k] == -1? false:true;
        
        if(i == s1.length() && j == s2.length()) {
            dp[i][j][k] = 1;
            return true;
        }else if(i == s1.length()){
            if(s2.charAt(j) == s3.charAt(k) && getString(s1,s2,s3,i,j+1,k+1, dp)) {
                dp[i][j][k] = 1;
                return true;
            }
        } else if(j == s2.length()){
            if(s1.charAt(i) == s3.charAt(k) && getString(s1,s2,s3,i+1,j,k+1,dp)) {
                dp[i][j][k] = 1;
                return true;
            }
        } else if(s1.charAt(i) == s3.charAt(k) && s2.charAt(j) == s3.charAt(k)){
            if(getString(s1, s2, s3, i+1, j, k+1,dp)) {
                dp[i][j][k] = 1;
                return true;
            }
            if(getString(s1, s2, s3, i, j+1, k+1,dp)) {
                dp[i][j][k] = 1;
                return true;
            }
        } else if(s1.charAt(i) == s3.charAt(k)) {
            if(getString(s1, s2, s3, i+1, j, k+1,dp)) {
                dp[i][j][k] = 1;
                return true;
            }
        } else if(s2.charAt(j) == s3.charAt(k)) {
            if(getString(s1, s2, s3, i, j+1, k+1,dp)) {
                dp[i][j][k] = 1;
                return true;
            }
        }
        dp[i][j][k] = -1;
        return false;
    }
}