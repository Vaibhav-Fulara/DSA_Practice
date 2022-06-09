// Memoisation
// TC = O(N^2)
// SC = O(N^2) + O(N)
/*
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
*/

// Tabulation
// TC = O(N^2)
// SC = O(N^2)
/*
class Solution {
    public int minInsertions(String s1) {
        int n = s1.length();
        StringBuilder sb = new StringBuilder(s1);
        String s2 = sb.reverse().toString();
        int[][]dp = new int[n+1][n+1];
        for(int i=s2.length()-1; i>=0; i--){
            for(int j=s1.length()-1; j>=0; j--){
                if(s1.charAt(i) == s2.charAt(j)) dp[i][j] = 1 + dp[i+1][j+1];
                else dp[i][j] = Math.max(dp[i+1][j], dp[i][j+1]);
            }
        }
        return n - dp[0][0];
    }
}
*/

// Another approach

// tabulation

class Solution {
    public int minInsertions(String s) {
        int  i = 0, j = s.length()-1;
        
        int[][]dp = new int[s.length()][s.length()];
        for(int[]ar:dp) Arrays.fill(ar,-1);
        
        return s.length() - getPalindrome(s, i, j, dp);
    }
    public int getPalindrome(String s, int i, int j, int[][]dp){
        if(i>j) return 0;
        if(i == j) return dp[i][j] = 1;
        
        if(dp[i][j] != -1) return dp[i][j];
        if(s.charAt(i) == s.charAt(j)){
            return dp[i][j] = 2 + getPalindrome(s, ++i, --j, dp);
        }
        else return dp[i][j] = Math.max(getPalindrome(s, i+1, j, dp), getPalindrome(s, i, j-1, dp));
    }
}