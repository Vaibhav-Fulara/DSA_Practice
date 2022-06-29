// Memoization
/*
class Solution {
    public int maxCoins(int[] nums) {
        
        // Attachin 1 to pre and post of the array
        int[]arr = new int[nums.length+2];
        int idx = 0;
        arr[idx++] = 1;
        for(int val:nums) arr[idx++] = val;
        arr[idx] = 1;
        
        // Initializing the DP
        int[][]dp = new int[arr.length][arr.length];
        for(int[]ar:dp) Arrays.fill(ar, -1);
        
        return partition(arr, dp, 1, nums.length);
    }
    
    public int partition(int[]arr, int[][]dp, int i, int j){
        
        // If we have overlapping subprobs, we return 0
        
        if(i > j) return dp[i][j] = 0;
        
        if(dp[i][j] != -1) return dp[i][j];
        
        // We start from 1 balloon and go on upto the n balloons. The reverse would have
        // led to dependant subproblems.
        
        int max = Integer.MIN_VALUE;
        for(int k=i; k<=j; k++)
            max = Math.max(max, arr[i-1]*arr[j+1]*arr[k] 
                           + partition(arr, dp, i, k-1) 
                           + partition(arr, dp, k+1, j));
        return dp[i][j] = max;
    }
}
*/

class Solution {
    public int maxCoins(int[] nums) {
        
        // Attachin 1 to pre and post of the array
        int[]arr = new int[nums.length+2];
        int idx = 0;
        arr[idx++] = 1;
        for(int val:nums) arr[idx++] = val;
        arr[idx] = 1;
        
        // Initializing the DP
        int[][]dp = new int[arr.length][arr.length];
        
        for(int i=nums.length; i>0; i--){
            for(int j= i; j<=nums.length; j++){
                int max = Integer.MIN_VALUE;
                for(int k=i; k<=j; k++)
                    max = Math.max(max, arr[i-1]*arr[j+1]*arr[k] 
                                   + dp[i][k-1] + dp[k+1][j]);
                dp[i][j] = max;
            }
        }
        
        return dp[1][nums.length];
    }
}