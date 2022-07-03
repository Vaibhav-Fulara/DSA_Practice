class Solution {
    public boolean wordBreak(String s, List<String> dict) {
        int[][]dp = new int[s.length()+1][s.length()+1];
        return solve(dict, s, 0, 0, dp);
    }
    
    public boolean solve (List<String>dict, String s, int i, int j, int[][]dp){
        if(j == s.length()){
            if(dict.contains(s.substring(i, j))) {
                dp[i][j] = 1;
                return true;
            }
            dp[i][j] = -1;
            return false;
        }
        
        if(dp[i][j] != 0) return dp[i][j] == 1? true:false;
        
        if(dict.contains(s.substring(i, j))){
            if(solve(dict, s, j,  j, dp)) {
                dp[i][j] = 1;
                return true;
            }
        }
        if(solve(dict, s, i, j+1, dp)) {
            dp[i][j] = 1;
            return true;
        }
        dp[i][j] = -1;
        return false;
    }
}