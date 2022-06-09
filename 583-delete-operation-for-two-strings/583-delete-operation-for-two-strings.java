/*
class Solution {
    public int minDistance(String word1, String word2) {
        int[][]dp = new int[word1.length()][word2.length()];
        for(int[]arr:dp) Arrays.fill(arr,-1);
        return word1.length() + word2.length() - 2*LCS(word1, word2, 0, 0, dp);
    }
    public int LCS(String s1, String s2, int i, int j, int[][]dp){
        if(i >= s1.length() || j >= s2.length()) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        if(s1.charAt(i) == s2.charAt(j)) return dp[i][j] = 1 + LCS(s1, s2, i+1, j+1, dp);
        else return dp[i][j] = Math.max(LCS(s1, s2, i+1, j, dp), LCS(s1, s2, i, j+1, dp));
    }
}
*/

class Solution {
    public int minDistance(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        
        int[][]dp = new int[m+1][n+1];
        
        for(int i=0; i<m+1; i++){
            for(int j=0; j<n+1; j++){
                if(i==0 || j==0) dp[i][j] = 0;
                else if(s1.charAt(i-1) == s2.charAt(j-1)) dp[i][j] = 1 + dp[i-1][j-1];
                else dp[i][j] = Math.max (dp[i-1][j], dp[i][j-1]);
            }
        }
        
        return m+n-dp[m][n]*2;
    }
}