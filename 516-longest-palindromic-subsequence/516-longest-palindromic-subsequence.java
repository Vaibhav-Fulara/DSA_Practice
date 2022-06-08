// Recursion
// TC = O(2^N)
/*
class Solution {
    public int longestPalindromeSubseq(String s) {
        int  i = 0, j = s.length()-1;
        return getPalindrome(s,i,j);
    }
    public int getPalindrome(String s, int i, int j){
        if(i>j) return 0;
        if(s.charAt(i) == s.charAt(j)){
            i++; j--;
            return 2 + getPalindrome(s, i, j);
        }
        else return Math.max(getPalindrome(s, i+1, j), getPalindrome(s, i, j-1));
    }
}
*/

// Memoization
// TC = O(N^2)
// SC = O(N^2) + O(N)
/*
class Solution {
    public int longestPalindromeSubseq(String s) {
        int  i = 0, j = s.length()-1;
        
        int[][]dp = new int[s.length()][s.length()];
        for(int[]ar:dp) Arrays.fill(ar,-1);
        
        return getPalindrome(s, i, j, dp);
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
*/

// Tabulation
/*
class Solution {
    public int longestPalindromeSubseq(String s) {
        
        int[][]dp = new int[s.length()][s.length()];
        
        for(int i=s.length()-1; i>=0; i--){
            for(int j=0; j<s.length(); j++){
                if(i>j) {
                    dp[i][j] = 0;
                    continue;
                }
                
                if(i == j) {
                    dp[i][j] = 1;
                    continue;
                }

                if(s.charAt(i) == s.charAt(j)){
                    dp[i][j] = 2 + dp[i+1][j-1];
                    continue;
                }
                else dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
            }
        }
        
        return dp[0][s.length()-1];
    }
}
*/

// Another approach

class Solution{
    public int longestPalindromeSubseq(String s1){
        int n = s1.length();
        StringBuilder sb = new StringBuilder(s1);
        String s2 = sb.reverse().toString();
        int[][]dp = new int[n][n];
        for(int[]arr:dp) Arrays.fill(arr, -1);
        return getMaxSubseq(s1, s2, dp, 0, 0);
    }
    public int getMaxSubseq(String s1, String s2, int[][]dp, int i, int j){
        if(i == s1.length() || j == s2.length()) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        if(s1.charAt(i) == s2.charAt(j)) return dp[i][j] = 1 + getMaxSubseq(s1, s2, dp, i+1, j+1);
        else return dp[i][j] = Math.max(getMaxSubseq(s1,s2,dp,i+1,j), getMaxSubseq(s1, s2, dp, i, j+1));
    } 
}