class Solution {
    public int minimumDeletions(String s) {
        Integer[][]dp = new Integer[s.length()][2];
        int ans = solve(s, 0, 0, dp);
        return ans;
    }
    public int solve(String s, int i, int flag, Integer[][]dp) {
        if(i == s.length()) return 0;
        int min = Integer.MAX_VALUE;
        
        if(dp[i][flag] != null) return dp[i][flag];
        
        if(flag == 0 && s.charAt(i) != 'a') {
            min = Math.min(min, 1 + solve(s, i+1, 0, dp));      // delete a and keep flag unchanged
            min = Math.min(min, solve(s, i+1, 1, dp));      // delete b and swap the flag variable
        } else if(flag == 1 && s.charAt(i) != 'b') {
            min = 1 + solve(s, i+1, flag, dp);          // only option is to delete b
        } else {
            min = solve(s, i+1, flag, dp);              // no deletion required
        }
        
        return dp[i][flag] = min;
    }
}