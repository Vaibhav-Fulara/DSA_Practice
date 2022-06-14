class Solution {
    public int jump(int[]arr) {
        int[]dp = new int[arr.length];
        Arrays.fill(dp, -1);
        return getJumps(arr, 0, dp);
    }
    public int getJumps(int[]arr, int i, int[]dp){
        if(i >= arr.length-1) return 0;
        
        if(dp[i] != -1) return dp[i];
        
        int val = arr[i], min = (int)1e8;
        for(int idx = 1; idx <= val; idx++) min = Math.min(min, getJumps(arr, i + idx, dp));
        return dp[i] = min + 1;
    }
}