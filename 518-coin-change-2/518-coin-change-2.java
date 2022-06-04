// Recursion
/*
class Solution {
    public int change(int tar, int[] arr) {
        return getWays(arr.length-1, tar, arr);
    }
    public int getWays(int i, int tar, int[]arr){
        if(i == 0){
            if(tar % arr[i] == 0) return 1;
            else return 0;
        }
        int include = 0;
        if(arr[i] <= tar) include = getWays(i, tar-arr[i], arr);
        int ignore = getWays(i-1, tar, arr);
        return include + ignore;
    }
}
*/

// Memoisation
class Solution {
    public int change(int tar, int[] arr) {
        int[][]dp = new int[arr.length][tar+1];
        for(int[]ar:dp) Arrays.fill(ar, -1);
        return getWays(arr.length-1, tar, arr, dp);
    }
    public int getWays(int i, int tar, int[]arr, int[][]dp){
        if(i == 0){
            if(tar % arr[i] == 0) return dp[i][tar] = 1;
            else return dp[i][tar] = 0;
        }
        
        if(dp[i][tar] != -1) return dp[i][tar];
        
        int include = 0;
        if(arr[i] <= tar) include = getWays(i, tar-arr[i], arr, dp);
        int ignore = getWays(i-1, tar, arr, dp);
        return dp[i][tar] = include + ignore;
    }
}