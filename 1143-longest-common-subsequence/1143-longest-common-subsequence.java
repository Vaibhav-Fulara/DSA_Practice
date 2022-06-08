// Recursion
// Time Complexity = O(2^n * 2^m)
// Space Complexity = O(m + n)
/*
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int i = text1.length()-1, j = text2.length()-1;
        return getLongestSS(text1, text2, i, j, dp);
    }
    public int getLongestSS(String s1, String s2, int i, int j, int[][]dp){
        if(i < 0 || j < 0) return 0;
        
        if(s1.charAt(i) == s2.charAt(j)) return 1 + getLongestSS(s1, s2, i-1, j-1, dp);
        else return Math.max (getLongestSS(s1, s2, i-1, j, dp), getLongestSS(s1, s2, i, j-1, dp));
    }
}
*/


// Memoization
// Time Complexity = O(m*n)
// Space Complexity = O(m*n) + O(max(m + n))
/*
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int i = text1.length()-1, j = text2.length()-1;
        
        int[][]dp = new int[i+1][j+1];
        for(int[]ar:dp) Arrays.fill(ar,-1);
        
        return getLongestSS(text1, text2, i, j, dp);
    }
    public int getLongestSS(String s1, String s2, int i, int j, int[][]dp){
        if(i < 0 || j < 0) return 0;
        
        if(dp[i][j] != -1) return dp[i][j];
        
        if(s1.charAt(i) == s2.charAt(j)) return dp[i][j] = 1 + getLongestSS(s1, s2, i-1, j-1, dp);
        else return dp[i][j] = Math.max (getLongestSS(s1, s2, i-1, j, dp), getLongestSS(s1, s2, i, j-1, dp));
    }
}
*/

// Tabulation
// Time Complexity = O(m*n)
// Space Complexity = O(m*n)
class Solution {
    public int longestCommonSubsequence(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        
        int[][]dp = new int[m+1][n+1];
        
        for(int i=0; i<m+1; i++){
            for(int j=0; j<n+1; j++){
                if(i==0 || j==0) {dp[i][j] = 0; continue;}
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                    continue;
                }
                dp[i][j] = Math.max (dp[i-1][j], dp[i][j-1]);
            }
        }
        
        return dp[m][n];
    }
}