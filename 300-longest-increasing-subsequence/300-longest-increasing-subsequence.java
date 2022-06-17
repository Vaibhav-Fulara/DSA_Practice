// Memoization
/*
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
*/

// Tabulation
/*
class Solution {
    public int lengthOfLIS(int[] arr) {
        int[][]dp = new int[arr.length + 1][arr.length + 1];
        
        for(int i = arr.length-1; i >= 0; i--){
            for(int prev = i-1; prev >= -1; prev--){
                int inc = Integer.MIN_VALUE;
        
                if(prev == -1 || arr[i] > arr[prev]) inc = 1 + dp[i+1][i+1];
                int ign = dp[i+1][prev+1];

                dp[i][prev+1] = Math.max(inc, ign);
            }
        }
        return dp[0][0];
    }
}
*/

// Spatial optimization
class Solution {
    public int lengthOfLIS(int[] arr) {
        int[]pre = new int[arr.length + 1];
        
        for(int i = arr.length-1; i >= 0; i--){
            int[]curr = new int[arr.length + 1];
            for(int prev = i-1; prev >= -1; prev--){
                int inc = Integer.MIN_VALUE;
        
                if(prev == -1 || arr[i] > arr[prev]) inc = 1 + pre[i+1];
                int ign = pre[prev+1];

                curr[prev+1] = Math.max(inc, ign);
            }
            pre = curr;
        }
        return pre[0];
    }
}