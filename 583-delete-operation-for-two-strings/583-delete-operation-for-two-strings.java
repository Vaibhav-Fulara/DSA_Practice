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