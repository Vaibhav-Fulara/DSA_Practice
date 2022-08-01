// Memoisation
// O(n) / O(n)
/*
class Solution {
    public String stoneGameIII(int[] stoneValue) {
        Integer[]dp = new Integer[stoneValue.length];
        int val = solve(stoneValue, 0, dp);
        if( val == 0) return "Tie";
        return val > 0 ? "Alice":"Bob";
    }
    public int solve(int[]arr, int i, Integer[]dp) {
        if(i >= arr.length) return 0;
        
        if(dp[i] != null) return dp[i];
        
        int max = Integer.MIN_VALUE;
        max = Math.max(max, arr[i] - solve(arr, i+1, dp));
        if(i < arr.length-1) max = Math.max(max, arr[i] + arr[i+1] - solve(arr, i+2, dp));
        if(i < arr.length-2) max = Math.max(max, arr[i] + arr[i+1] + arr[i+2] - solve(arr, i+3, dp));
        return dp[i] = max;
    }
}
*/

// Tabulation
class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        if(n == 0) return "Tie";
        Integer[]dp = new Integer[n+1];
        int val = solve(stoneValue, dp);
        if(val == 0) return "Tie";
        return val > 0 ? "Alice":"Bob";
    }
    public int solve(int[]arr, Integer[]dp) {        
        dp[dp.length-2] = arr[arr.length-1];
        dp[dp.length-1] = 0;
        for(int i=arr.length-2; i>=0; i--) {
            int max = Integer.MIN_VALUE;
            max = Math.max(max, arr[i] - dp[i+1]);
            if(i < arr.length-1) max = Math.max(max, arr[i] + arr[i+1] - dp[i+2]);
            if(i < arr.length-2) max = Math.max(max, arr[i] + arr[i+1] + arr[i+2] - dp[i+3]);
            dp[i] = max;
        }
        
        return dp[0];
    }
}