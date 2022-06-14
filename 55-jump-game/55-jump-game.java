class Solution {
    public boolean canJump(int[]arr) {
        boolean[]dp = new boolean[arr.length];
        
        for(int i = arr.length-1; i>=0; i--){
            int val = arr[i];
            boolean bool = false;
            for(int idx = val; idx >= 0; idx--){
                if(i + idx >= arr.length-1){
                    bool = true;
                    break;
                }
                bool = bool || dp[i + idx];
            }
            dp[i] = bool;
        }
        return dp[0];
    }
}

/*
class Solution {
    public boolean canJump(int[]arr) {
        int[]dp = new int[arr.length];
        Arrays.fill(dp, -1);
        return traverse(arr, 0, dp);
    }
    public boolean traverse(int[]arr, int i, int[]dp){
        if(i >= arr.length-1) return true;
        
        if(dp[i] != -1) return dp[i] == 0? false:true;
        
        int val = arr[i];
        boolean bool = false;
        for(int idx = 1; idx <= val; idx++){
            bool = bool || traverse(arr, i+idx, dp);
        }
        dp[i] = bool? 1:0;
        return bool;
    }
}
*/