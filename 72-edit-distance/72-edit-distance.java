// Memoization
/*
class Solution {
    public int minDistance(String s1, String s2) {
        int n1 = s1.length(), n2 = s2.length();
        int[][]dp = new int[n1][n2];
        for(int[]arr:dp) Arrays.fill(arr,-1);
        return solve(s1, s2, 0, 0, dp);
    }
    public int solve(String s1, String s2, int i, int j, int[][]dp){
        if(i == s1.length()) return s2.length()-j;
        if(j == s2.length()) return s1.length()-i;
        
        if(dp[i][j] != -1) return dp[i][j];
        
        if(s1.charAt(i) == s2.charAt(j)) return dp[i][j] = solve(s1, s2, i+1, j+1, dp);
        else return dp[i][j] = 1 + Math.min(solve(s1, s2, i+1, j, dp), Math.min(solve(s1, s2, i, j+1, dp), solve(s1, s2, i+1, j+1, dp)));
        //                                  // deletion                         // insertion                     // replacement
    }
}
*/

// Tabulation
/*
class Solution {
    public int minDistance(String s1, String s2) {
        int n1 = s1.length(), n2 = s2.length();
        int[][]dp = new int[n1+1][n2+1];
        for(int i=n1; i>=0; i--){
            for(int j=n2; j>=0; j--){
                if(i == n1) dp[i][j] = n2-j;
                else if(j == n2) dp[i][j] = n1-i;
                else if(s1.charAt(i) == s2.charAt(j)) dp[i][j] = dp[i+1][j+1];
                else dp[i][j] = 1 + Math.min(dp[i+1][j], Math.min(dp[i][j+1], dp[i+1][j+1]));
            }
        }
        return dp[0][0];
    }
}
*/

// Space Optimization
class Solution {
    public int minDistance(String s1, String s2) {
        int n1 = s1.length(), n2 = s2.length();
        int[]prev = new int[n2+1];
        for(int i=n1; i>=0; i--){
            int[]curr = new int[n2+1];
            for(int j=n2; j>=0; j--){
                if(i == n1) curr[j] = n2-j;
                else if(j == n2) curr[j] = n1-i;
                else if(s1.charAt(i) == s2.charAt(j)) curr[j] = prev[j+1];
                else curr[j] = 1 + Math.min(prev[j], Math.min(curr[j+1], prev[j+1]));
            }
            prev = curr;
        }
        return prev[0];
    }
}