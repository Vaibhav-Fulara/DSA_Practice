class Solution {
    public int minInsertions(String s1) {
        int n = s1.length();
        StringBuilder sb = new StringBuilder(s1);
        String s2 = sb.reverse().toString();
        int[][]dp = new int[n+1][n+1];
        for(int i=s2.length()-1; i>=0; i--){
            for(int j=s1.length()-1; j>=0; j--){
                if(s1.charAt(i) == s2.charAt(j)) dp[i][j] = 1 + dp[i+1][j+1];
                else dp[i][j] = Math.max(dp[i+1][j], dp[i][j+1]);
            }
        }
        return n - dp[0][0];
    }
}