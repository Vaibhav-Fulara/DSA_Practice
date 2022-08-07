class Solution {
    final int big = (int)(1e9+7);
    public int countVowelPermutation(int n) {
        Integer[][]dp = new Integer[n+1][5];
        char[]arr = new char[]{'a', 'e', 'i', 'o', 'u'};
        return solve(n, arr, -1, dp);
    }
    public int solve(int n, char[]arr, int i, Integer[][]dp) {
        if(n == 0) return 1;
        
        if(i != -1 && dp[n][i] != null) return dp[n][i];
        long ans = 0l;
        
        if(i == 0) {
            ans = solve(n-1, arr, 1, dp) % big;
        } else if(i == 1) {
            ans += solve(n-1, arr, 0, dp) % big;
            ans += solve(n-1, arr, 2, dp) % big;
        } else if(i == 2) {
            for(int k=0; k<5; k++) {
                if(k == 2) continue;
                ans += solve(n-1, arr, k, dp);
                ans %= big;
            }
        } else if(i == 3) {
            ans += solve(n-1, arr, 2, dp) % big;
            ans += solve(n-1, arr, 4, dp) % big;
        } else if(i == 4) {
            ans = solve(n-1, arr, 0, dp) % big;
        } else {
            for(int k=0; k<5; k++) {
                ans += solve(n-1, arr, k, dp);
                ans %= big;
            }
        }
        
        if(i == -1) return (int)(ans % big);
        return dp[n][i] = (int)(ans % big);
    }
}