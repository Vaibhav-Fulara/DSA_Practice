class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int n1 = s1.length(), n2 = s2.length();
        
        int[][]dp = new int[n1][n2];
        for(int[]ar:dp) Arrays.fill(ar, -1);
        
        int ans = solve(s1, s2, dp, 0, 0);
        // System.out.println(ans);
        
        int sum = 0;
        for(char ch:s1.toCharArray()) sum += (int)ch;
        for(char ch:s2.toCharArray()) sum += (int)ch;
        
        return sum - 2 * ans;
    }
    public int solve(String s1, String s2, int[][]dp, int i, int j){
        if(i == s1.length() || j == s2.length()) return 0;
        
        if(dp[i][j] != -1) return dp[i][j];
        
        int inc = 0, ign1 = 0, ign2 = 0;
        if(s1.charAt(i) == s2.charAt(j)){
            inc = (int)s1.charAt(i) + solve(s1, s2, dp, i+1, j+1);
        }
        ign1 = solve(s1, s2, dp, i+1, j);
        ign2 = solve(s1, s2, dp, i, j+1);
        
        return dp[i][j] = Math.max(inc, Math.max(ign1, ign2));
    }
}