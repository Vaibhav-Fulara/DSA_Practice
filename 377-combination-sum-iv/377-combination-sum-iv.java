class Solution {
    
    public int combinationSum4(int[]arr, int tar) {
        int[]dp = new int[tar+1];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        return getAns(arr,tar,dp);
    }
    public int getAns(int[]arr, int tar, int[]dp){
        if(dp[tar] != -1) return dp[tar];
        int ans = 0;
        for(int i=0; i<arr.length; i++){
            int val = arr[i];
            if(val <= tar) ans += getAns(arr, tar-val, dp);
        }
        return dp[tar] = ans;
    }
}