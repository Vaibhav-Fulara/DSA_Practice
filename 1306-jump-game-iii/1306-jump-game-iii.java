// Recursion
/*
class Solution {
    public boolean canReach(int[] arr, int i) {
        if(arr[i] == 0) return true;
        if(arr[i] < 0) return false;
        
        arr[i] = -arr[i];
        if(i+arr[i] >= 0 && canReach(arr, i+arr[i])) return true;
        if(i-arr[i] < arr.length && canReach(arr, i-arr[i])) return true;
        arr[i] = -arr[i];
        
        return false;
    }
}
*/

// Memoization
// /*
class Solution {
    public boolean canReach(int[] arr, int start) {
        int[]dp = new int[arr.length];
        return getPath(arr, start, dp);
    }
    public boolean getPath(int[]arr, int i, int[]dp){
        if(arr[i] == 0) return true;
        
        if(arr[i] < 0){
            dp[i] = -1;
            return false;
        }
        
        if(dp[i] != 0) return dp[i] == -1 ? false:true;
        
        arr[i] = -arr[i];
        
        if(i+arr[i] >= 0){
            if(getPath(arr, i+arr[i], dp)) {
                dp[i+arr[i]] = 1;
                return true;
            }
        }
        
        if(i-arr[i] < arr.length){
            if(getPath(arr, i-arr[i], dp)) {
                dp[i-arr[i]] = 1;
                return true;
            }
        }
        
        arr[i] = -arr[i];
        
        dp[i] = -1;
        return false;
    }
}
// */