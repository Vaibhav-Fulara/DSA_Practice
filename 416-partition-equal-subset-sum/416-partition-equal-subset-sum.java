class Solution {
    public boolean canPartition(int[]arr) {
        int sum = 0;
        for(int val:arr) sum += val;
        if(sum % 2 != 0) return false;
        int k = sum/2;
        
        boolean[][]dp = new boolean[arr.length +1][k + 1];
        for(boolean[]val:dp) val[0] = true;
        
        for(int i=arr.length-1; i>=0; i--){
            if(arr[i] <= k) dp[i][arr[i]] = true;
            for(int tar = 1; tar<=k; tar++){
                boolean contain = false;
                if(arr[i] <= tar) contain = dp[i+1][tar - arr[i]];
                boolean ignore = dp[i+1][tar];
                dp[i][tar] = contain || ignore;
            }
        }
        return dp[0][k];
    }
}
