class Solution {
    public boolean isMatch(String s, String p) {
        return s.matches(p);
    }
}
/*
class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][]dp = new boolean[s.length()+1][p.length()+1];
        for(int i=0; i<=s.length(); i++){
            for(int j = 0; j <= p.length(); j++){
                if(i == 0 && j == 0) dp[i][j] = true;
                else if(j == 0) dp[i][j] = false;
                else if(i == 0){
                    boolean flag = true;
                    for(int k=0; k<=j; k++) if(p.charAt(j-1) != '*') flag = false;
                    if(flag) dp[i][j] = true;
                }

                else if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '.') dp[i][j] = dp[i-1][j-1];
                else if(p.charAt(j-1) == '*') dp[i][j] = dp[i-1][j] || dp[i][j-1];
                else dp[i][j] = false;
            }
        }
        return dp[s.length()][p.length()];
    }
}
*/