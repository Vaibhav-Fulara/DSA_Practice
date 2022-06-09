class Solution {
    public int minInsertions(String s) {
        return s.length() - longestPalindrome(s);
    }
    
    public int longestPalindrome(String s1){
        StringBuilder sb = new StringBuilder(s1);
        String s2 = sb.reverse().toString();
        int[][]dp = new int[s1.length()][s2.length()];
        for(int[]arr:dp) Arrays.fill(arr,-1);
        return getLongestSubstring(s1, s2, 0, 0, dp);
    }
    
    public int getLongestSubstring(String s1, String s2, int i, int j, int[][]dp){
        if(i == s1.length() || j == s2.length()) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        if(s1.charAt(i) == s2.charAt(j)) return dp[i][j] = 1 + getLongestSubstring(s1, s2, i+1, j+1, dp);
        else return dp[i][j] = Math.max(getLongestSubstring(s1, s2, i+1, j, dp), getLongestSubstring(s1, s2, i, j+1, dp));
    }
}