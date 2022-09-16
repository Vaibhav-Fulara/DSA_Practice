class Solution {
    public int maxCoins(int[] nums) {
        
        // Build an untruncated array
        int[]arr = new int[nums.length + 2];
        int i = 0;
        arr[i++] = 1;
        for(int val:nums) arr[i++] = val;
        arr[i] = 1;
        
        // create a dp
        int[][]dp = new int[arr.length][arr.length];
        
        for(int lo = arr.length-2; lo > 0; lo--) {
            for(int hi = lo; hi < arr.length-1; hi++) {
                int max = Integer.MIN_VALUE;
                for(int idx=lo; idx<=hi; idx++) {
                    max = Math.max(max, arr[lo-1]*arr[idx]*arr[hi+1] + dp[lo][idx-1] + dp[idx+1][hi]);
                }
                dp[lo][hi] = max;
            }
        }
        
        return dp[1][arr.length-2];
    }
}