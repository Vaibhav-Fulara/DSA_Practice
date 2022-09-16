class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a,b)->a[0]-b[0]);
        int[][]dp = new int[pairs.length][pairs.length];
        for(int[]a:dp) Arrays.fill(a,-1);
        return solve(pairs, dp, -1, 0);
    }
    public int solve(int[][]arr, int[][]dp, int old, int idx) {
        if(idx == arr.length) return 0;
        if(old != -1 && dp[old][idx] != -1) return dp[old][idx];
        int max = Integer.MIN_VALUE;
        if(old == -1 || arr[old][1] < arr[idx][0]) {
            max = 1 + solve(arr, dp, idx, idx+1);
        }
        if(old != -1) return dp[old][idx] = Math.max(max, solve(arr, dp, old, idx+1));
        return Math.max(max, solve(arr, dp, old, idx+1));
    }
}