class Solution {
    public int lengthOfLIS(int[] nums) {
        int[][]dp = new int[nums.length][nums.length];
        for(int[]arr:dp) Arrays.fill(arr, -1);
        return getLIS(nums, -1, dp, 0);
    }
    public int getLIS(int[]arr, int prev, int[][]dp, int i){
        if(i == arr.length) return 0;
        if(prev != -1 && dp[prev][i] != -1) return dp[prev][i];
        
        int max = Integer.MIN_VALUE, inc = Integer.MIN_VALUE;
        
        if(prev == -1 || arr[i] > arr[prev]) inc = 1 + getLIS(arr, i, dp, i+1);
        int ign = getLIS(arr, prev, dp, i+1);
        
        if(prev != -1) return dp[prev][i] = Math.max(inc, ign);
        return Math.max(inc, ign);
    }
}