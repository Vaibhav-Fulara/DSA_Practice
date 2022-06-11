// Memoizzation
// Memory Limit Exceeded due to large x
/*
class Solution {
    public int minOperations(int[]arr, int x) {
        
        int[][][]dp = new int[arr.length][arr.length][x+1];
        for(int[][]val:dp) for(int[]nums:val) Arrays.fill(nums, -1);
        int ans = getMinMoves(arr, x, 0, arr.length-1, dp);
        return ans >= 1e6? -1:ans;
    }
    public int getMinMoves(int[]arr, int x, int i, int j, int[][][]dp){
        if(x == 0) return 0;
        if(i > j) return (int)1e6;
        
        int left = (int) 1e6, right = (int) 1e6;
        
        if(dp[i][j][x] != -1) return dp[i][j][x];
        
        if(arr[i] <= x) left = getMinMoves(arr, x-arr[i], i+1, j, dp);
        if(arr[j] <= x) right = getMinMoves(arr, x-arr[j], i, j-1, dp);
        return dp[i][j][x] = 1 + Math.min(left, right);
    }
}
*/

class Solution {
    public int minOperations(int[]arr, int x) {
        
        int sum = 0;
        for(int val:arr) sum += val;
        
        int tar = sum - x;
        if(tar == 0) return arr.length;
        
        int i=0, len = 0, curr = 0;
        for(int j = 0; j<arr.length; j++){
            curr += arr[j];
            while(i<arr.length && curr > tar) curr -= arr[i++];
            if(curr == tar) len = Math.max(len, j-i+1);
            if(i == arr.length) break;
        }
        return len == 0? -1 : arr.length-len;
    }
}
