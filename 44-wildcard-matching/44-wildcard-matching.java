// Recursion
/*
class Solution {
    public boolean isMatch(String s, String p) {
        return solve(s, p, s.length()-1, p.length()-1);
    }
    public boolean solve(String s1, String s2, int i, int j){
        if(i<0 && j<0) return true;
        if(i<0 || j<0) return false;
        
        if(s2.charAt(j) == '?' || s2.charAt(j) == s1.charAt(i)) return solve(s1, s2, i-1, j-1);
        else if(s2.charAt(j) == '*') return solve(s1, s2, i-1, j) || solve(s1, s2, i-1, j-1);
        else return false;
    }
}
*/

// Memoization

class Solution {
    public boolean isMatch(String s, String p) {
        int[][]dp  =new int[s.length()][p.length()];
        return solve(s, p, s.length()-1, p.length()-1, dp);
    }
    public boolean solve(String s1, String s2, int i, int j, int[][]dp){
        if(i<0 && j<0) return true;
        if(j<0) return false;
        else if(i<0){
            for(int k=0; k<=j; k++) if(s2.charAt(k) != '*') return false;
            return true;
        }
        
        if(dp[i][j] != 0) return dp[i][j] == 1? true:false;
        
        if(s2.charAt(j) == '?' || s2.charAt(j) == s1.charAt(i)) {
            boolean bool = solve(s1, s2, i-1, j-1, dp);
            dp[i][j] = bool? 1:-1;
            return bool;
        }
        
        else if(s2.charAt(j) == '*') {
            boolean bool = solve(s1, s2, i-1, j, dp) || solve(s1, s2, i, j-1, dp);
            dp[i][j] = bool? 1:-1;
            return bool;
        }
        
        dp[i][j] = -1;
        return false;
    }
}