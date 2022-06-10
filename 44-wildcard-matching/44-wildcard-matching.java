// Recursion
/*
class Solution {
    public boolean isMatch(String s, String p) {
        return solve(s, p, s.length()-1, p.length()-1);
    }
    public boolean solve(String s1, String s2, int i, int j){
        if(i<0 && j<0) return true;
        if(j<0) return false;
        else if(i<0){
            for(int k=0; k<=j; k++) if(s2.charAt(k) != '*') return false;
            return true;
        }
        
        if(s2.charAt(j) == '?' || s2.charAt(j) == s1.charAt(i)) return solve(s1, s2, i-1, j-1);
        else if(s2.charAt(j) == '*') return solve(s1, s2, i-1, j) || solve(s1, s2, i, j-1);
        else return false;
    }
}
*/

// Memoization
/*
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
*/

// Tabulation
/*
class Solution {
    public boolean isMatch(String s1, String s2) {
        boolean[][]dp  =new boolean[s1.length()+1][s2.length()+1];
        for(int i=0; i<=s1.length(); i++){
            for(int j=0; j<=s2.length(); j++){
                if(i == 0 && j == 0) {dp[i][j] = true; continue;}
                else if(j==0) continue;
                else if(i == 0){
                    boolean flag = true;
                    for(int k=1; k<=j; k++) if(s2.charAt(k-1) != '*') flag = false;
                    if(flag) dp[i][j] = true;
                    continue;
                }
                
                if(s2.charAt(j-1) == '?' || s2.charAt(j-1) == s1.charAt(i-1)) dp[i][j] = dp[i-1][j-1];
                else if(s2.charAt(j-1) == '*') dp[i][j] = dp[i-1][j] || dp[i][j-1];
                else dp[i][j] = false;
            }
        }
        return dp[s1.length()][s2.length()];
    }
}
*/

// Space Optimization
class Solution {
    public boolean isMatch(String s1, String s2) {
        boolean[]prev  =new boolean[s2.length()+1];
        for(int i=0; i<=s1.length(); i++){
            boolean[]curr  =new boolean[s2.length()+1];
            for(int j=0; j<=s2.length(); j++){
                if(i == 0 && j == 0) {curr[j] = true; continue;}
                else if(j==0) continue;
                else if(i == 0){
                    boolean flag = true;
                    for(int k=1; k<=j; k++) if(s2.charAt(k-1) != '*') flag = false;
                    if(flag) curr[j] = true;
                    continue;
                }
                
                if(s2.charAt(j-1) == '?' || s2.charAt(j-1) == s1.charAt(i-1)) curr[j] = prev[j-1];
                else if(s2.charAt(j-1) == '*') curr[j] = prev[j] || curr[j-1];
                else curr[j] = false;
            }
            prev = curr;
        }
        return prev[s2.length()];
    }
}