class Solution {
    public int stoneGameVII(int[] stones) {
        int n = stones.length;
        Integer[][]dp = new Integer[n][n];
        int sum = 0;
        for(int val:stones) sum += val;
        return solve(stones, 0, n-1, sum, dp);
    }
    public int solve(int[]arr, int strt, int end, int sum, Integer[][]dp) {
        if(strt == end) return 0;
        
        if(dp[strt][end] != null) return dp[strt][end];
        
        int first = sum - arr[strt] - solve(arr, strt+1, end, sum - arr[strt], dp);
        int last = sum - arr[end] - solve(arr, strt, end-1, sum - arr[end], dp);
        return dp[strt][end] = Math.max(first, last);
    }
}