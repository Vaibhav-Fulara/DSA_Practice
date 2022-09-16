// Memoization
// O(n^2) || O(n^2)
/*
class Solution {
    public int maximumScore(int[] arr, int[] mul) {
        int[][]dp = new int [arr.length][arr.length];
        for(int[]a:dp) Arrays.fill(a, -1);
        return solve(dp, 0, arr.length-1, arr, mul);
    }
    public int solve(int[][]dp, int i, int j, int[]arr, int[]mul) {
        if(arr.length-j+i-1 >= mul.length) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int idx = arr.length-j+i-1;
        int max = Math.max(arr[i]*mul[idx] + solve(dp, i+1, j, arr, mul), 
                           arr[j]*mul[idx] + solve(dp, i, j-1, arr, mul));
        return dp[i][j] = max;
    }
}
*/

// Tabulation
// O(n^2) || O(n^2)
/*
class Solution {
    public int maximumScore(int[] arr, int[] mul) {
        int[][]dp = new int [arr.length+1][arr.length+1];
        
        for(int i=arr.length-1; i>=0; i--) {
            for(int j=0; j<arr.length; j++) {
                int idx = arr.length-j+i-1;
                if(idx >= mul.length) continue;
                
                int v1 = 0;
                int v2 = 0;
                
                if(i < dp.length-1) v1 = dp[i+1][j];
                if(j > 0) v2 = dp[i][j-1];
                
                int max = Math.max(arr[i]*mul[idx] + v1,
                                   arr[j]*mul[idx] + v2);
                dp[i][j] = max;
            }
        }
        
        return dp[0][arr.length-1];
    }
}
*/

// Spatial Optimization
// O(n^2) || O(n)
/*
class Solution {
    public int maximumScore(int[] arr, int[] mul) {
        
        int[]olda = new int[arr.length];
        for(int i=arr.length-1; i>=0; i--) {
            int[]newa = new int[arr.length];
            for(int j=0; j<arr.length; j++) {
                int idx = arr.length-j+i-1;
                if(idx >= mul.length) continue;
                
                int v1 = 0;
                int v2 = 0;
                if(i < newa.length-1) v1 = olda[j];
                if(j > 0) v2 = newa[j-1];
                
                int max = Math.max(arr[i]*mul[idx] + v1,
                                   arr[j]*mul[idx] + v2);
                newa[j] = max;
            }
            olda = newa;
        }
        
        return olda[arr.length-1];
    }
}
*/

class Solution {
    int N, M;
    public int maximumScore(int[] nums, int[] multipliers) {
        N = nums.length;
        M = multipliers.length;
	    return helper(nums, multipliers, 0, 0, new Integer[M][M]);
    }

    private int helper(int[] nums, int[] multipliers, int left, int index, Integer[][] dp) {
	    int right = N - 1 - (index - left);
	    if (index == M) return 0;

	    if (dp[left][index] != null) return dp[left][index];

	    int res = Math.max(
            nums[left] * multipliers[index] + helper(nums, multipliers, left+1, index+1, dp), 
            nums[right] * multipliers[index] + helper(nums, multipliers, left, index+1, dp));

        dp[left][index] = res;
	    return res;
    }
}