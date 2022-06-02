class Solution {
    public boolean canPartition(int[]arr) {
        int sum = 0;
        for(int val:arr) sum += val;
        if(sum % 2 != 0) return false;
        
        int[][]dp = new int[arr.length +1][sum/2 + 1];
        for(int[]sub:dp) Arrays.fill(sub, -1);
        
        return getSS(sum/2, arr, 0, dp);
    }
    public boolean getSS(int tar, int[]arr, int i, int[][]dp){
        if(tar == 0) {
            dp[i][tar] = 1;
            return true;
        }
        
        if(i >= arr.length) {
            dp[i][tar] = 0;
            return false;
        }
        
        if(dp[i][tar] != -1){
            if(dp[i][tar] == 0) return false;
            return true;
        }
        
        boolean contain = false;
        if(arr[i] <= tar) contain = getSS(tar - arr[i], arr, i+1, dp);
        boolean ignore = getSS(tar, arr, i+1, dp);
        boolean ans = contain || ignore;
        dp[i][tar] = ans == true? 1:0;
        return ans;
    }
}