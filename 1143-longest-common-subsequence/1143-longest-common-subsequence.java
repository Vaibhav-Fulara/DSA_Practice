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