// Memoisation
/*
class Solution {
    public int jump(int[]arr) {
        int[]dp = new int[arr.length];
        Arrays.fill(dp, -1);
        return getJumps(arr, 0, dp);
    }
    public int getJumps(int[]arr, int i, int[]dp){
        if(i >= arr.length-1) return 0;
        
        if(dp[i] != -1) return dp[i];
        
        int val = arr[i], min = (int)1e8;
        for(int idx = 1; idx <= val; idx++) min = Math.min(min, getJumps(arr, i + idx, dp));
        return dp[i] = min + 1;
    }
}
*/

// Tabulation
class Solution {
    public int jump(int[]arr) {
        if(arr.length < 2) return 0;
        int[]dp = new int[arr.length];
        
        for(int i=arr.length-1; i>=0; i--){
            int val = arr[i], min = (int)1e8;
            for(int idx = 1; idx <= val; idx++){
                if(i + idx >= arr.length-1) {min = 0; break;}
                else min = Math.min(min, dp[i+idx]);
            } 
            dp[i] = min + 1;
        }
        return dp[0];
    }
}