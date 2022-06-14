// Memoization
// TC = O(n) TLE
// SC = O(n)
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

// Tabulation
// TC = O(n)
// SC = O(n)
// /*
class Solution {
    public boolean canJump(int[]arr) {
        if(arr.length < 2) return true;
        boolean[]dp = new boolean[arr.length];
        
        for(int i = arr.length-1; i>=0; i--){
            int val = arr[i];
            boolean bool = false;
            for(int idx = 0; idx <= val; idx++){
                if(i + idx >= arr.length-1) bool = true;
                bool = bool || dp[i + idx];
                if(bool) break;
            }
            dp[i] = bool;
        }
        return dp[0];
    }
}
// */

// Alternate Approach
/*
public class Solution {
    public boolean canJump(int[]arr) {
       if(arr.length < 2) return true;
       
       for(int curr = arr.length-2; curr>=0; curr--){        // start from n-2 as we dont care if there is a 0 element on n-1
           // System.out.println(curr);
           if(arr[curr] == 0){
               int neededJumps = 1;               // Jumps required to skip the 0 value
               while(neededJumps > arr[curr]){    // If we encounter a 0 valued index, we have to skip jumping over it
                   neededJumps++;                 // Increasing the jump required every time we undergo an unsuccessful shift
                   curr--;                        // shifting (decrementing value) to the left of index
                   if(curr < 0) return false;
               }
           }
       }
       return true;
    }
}
*/