class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 1) return 1;
        int[][]dp = new int[nums.length][nums.length];
        for(int[]arr:dp) Arrays.fill(arr, -1);
        return getLIS(nums, 0, -1, dp);
    }
    public int getLIS(int[]arr, int i, int lo, int[][]dp){
        if(i == arr.length) return 0;
        
        if(lo != -1 && dp[i][lo] != -1) return dp[i][lo];
        
        int val = getLIS(arr, i+1, lo, dp);
        if(lo == -1) return Math.max(1 + getLIS(arr, i+1, i, dp), val);
        if(arr[i] > arr[lo]) return dp[i][lo] = Math.max(1 + getLIS(arr, i+1, i, dp), val);
        else return dp[i][lo] = val;
    }
}