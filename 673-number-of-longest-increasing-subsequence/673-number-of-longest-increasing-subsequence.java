class Solution {
    public int findNumberOfLIS(int[] arr) {
        int[]dp = new int[arr.length];
        int[]hash = new int[arr.length];
        
        for(int i=0; i<arr.length; i++){
            dp[i] = 1; hash[i] = 1;
            for(int j=0; j<i; j++){
                if(arr[i] > arr[j] && dp[i] == dp[j]+1) hash[i] += hash[j];
                if(arr[i] > arr[j] && dp[i] < dp[j] + 1){
                    hash[i] = hash[j];
                    dp[i] = dp[j] + 1;
                }
            }
        }
        
        int max = 1;
        int count = 0;
        for(int i=0; i<dp.length; i++){
            if(dp[i] == max){
                count += hash[i];
            } else if (dp[i] > max){
                max = dp[i];
                count = hash[i];
            }
        }
        
        return count;
    }
}