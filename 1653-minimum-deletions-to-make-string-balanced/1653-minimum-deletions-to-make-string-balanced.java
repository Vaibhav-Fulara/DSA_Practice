// O(n^2)
/*
class Solution {
    
    public int minimumDeletions(String s) {
        Integer[][]dp = new Integer[s.length()][2];
        return solve(s, 0, 0, dp);
    }
    
    public int solve(String s, int i, int flag, Integer[][]dp) {
        
        if(i == s.length()) return 0;
        int min = Integer.MAX_VALUE;
        
        if(dp[i][flag] != null) return dp[i][flag];
        
        if(flag == 0 && s.charAt(i) != 'a') {
            min = Math.min(min, 1 + solve(s, i+1, 0, dp));      // delete a and keep flag unchanged
            min = Math.min(min, solve(s, i+1, 1, dp));          // delete b and swap the flag variable
        } else if(flag == 1 && s.charAt(i) != 'b') {
            min = 1 + solve(s, i+1, flag, dp);          // only option is to delete b
        } else {
            min = solve(s, i+1, flag, dp);              // no deletion required
        }
        
        return dp[i][flag] = min;
    }
}
*/

// O(n)
class Solution {
    public int minimumDeletions(String s) {
        int l = s.length();
        int[] dp = new int[l + 1];
        int bcount = 0;
        for (int i = 0; i < l; i++) {
            if (s.charAt(i) == 'a') {
                dp[i + 1] = Math.min(dp[i] + 1, bcount);
            } else {
                dp[i + 1] = dp[i];
                bcount++;
            }
        }
        
        return dp[l];
    }
}