class Solution {
    public int numDistinct(String s, String t) {
        int[][]dp = new int[s.length()][t.length()];
        for(int[]arr:dp) Arrays.fill(arr,-1);
        return getMinSubseq(s, t, 0, 0, dp);
    }
    public int getMinSubseq(String s1, String s2, int i, int j, int[][]dp){
        if(j == s2.length()) return 1;
        if(i == s1.length()) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        if(s1.charAt(i) == s2.charAt(j)) return dp[i][j] = getMinSubseq(s1, s2, i+1, j+1, dp) + getMinSubseq(s1, s2, i+1, j, dp);
        else return dp[i][j] = getMinSubseq(s1, s2, i+1, j, dp);
    }
}