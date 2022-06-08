// Recursion
// TC = O(2^n)
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