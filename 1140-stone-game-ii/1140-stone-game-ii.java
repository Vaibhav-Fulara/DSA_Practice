class Solution {
    public int stoneGameII(int[] piles) {
        int sum = 0;
        for(int val:piles) sum += val;
        
        if(piles.length < 3) return sum;
        Integer[][]dp = new Integer[piles.length + 1][piles.length + 1];
        return (sum + solve(piles, 0, 1, dp)) / 2;
    }
    
    public int solve(int[]arr, int strt, int m, Integer[][]dp) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        
        if(dp[strt][m] != null) return dp[strt][m];
        if(strt + 2*m >= arr.length) {
            for(int i=strt; i < arr.length; i++) sum += arr[i];
            return sum;
        }
        
        for(int i=1; i <= 2*m; i++) {
            sum += arr[strt + i - 1];
            max = Math.max(max, sum - solve(arr, strt + i, Math.max(m, i), dp));
        }
        
        return dp[strt][m] = max;
    }
}