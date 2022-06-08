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