// Memoization
// TC = O(m*n)
// SC = O(m*n) + O(m+n)
/*
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
*/

// Tabulation

class Solution {
    public int numDistinct(String s, String t) {
        int[][]dp = new int[s.length()+1][t.length()+1];
        
        for(int i=0; i<dp.length; i++) dp[i][t.length()] = 1;
            
        for(int i = s.length()-1; i>=0; i--){
            for(int j = t.length()-1; j>=0; j--){
                if(s.charAt(i) == t.charAt(j)) dp[i][j] = dp[i+1][j+1] + dp[i+1][j];
                else dp[i][j] = dp[i+1][j];
            }
        }
        return dp[0][0];
    }
}