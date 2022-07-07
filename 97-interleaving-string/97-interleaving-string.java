// Way1 cache all states for i,j & k
/*
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
*/

// Way 2 cache only invalid i and j
class Solution{
    public boolean isInterleave(String s1, String s2, String s3) {
        char[] c1 = s1.toCharArray(), c2 = s2.toCharArray(), c3 = s3.toCharArray();
        int m = s1.length(), n = s2.length();
        if(m + n != s3.length()) return false;
        return dfs(c1, c2, c3, 0, 0, 0, new boolean[m + 1][n + 1]);
    }

    public boolean dfs(char[] c1, char[] c2, char[] c3, int i, int j, int k, boolean[][] invalid) {
        if(invalid[i][j]) return false;
        if(k == c3.length) return true;
        boolean valid = 
            i < c1.length && c1[i] == c3[k] && dfs(c1, c2, c3, i + 1, j, k + 1, invalid) || 
            j < c2.length && c2[j] == c3[k] && dfs(c1, c2, c3, i, j + 1, k + 1, invalid);
        if(!valid) invalid[i][j] = true;
        return valid;
    }
}