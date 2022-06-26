// Solution 1 TLE+MME
/*
class Solution {
    public int maxScore(int[]points, int k) {
        int n = points.length;
        
        int[][]dp = new int[n+1][n+1];
        for(int[]arr:dp) Arrays.fill(arr, -1);
        
        return getMaxScore(points, k, 0, n-1, dp);
    }
    public int getMaxScore(int[]arr, int k, int i, int j, int[][]dp){
        if(k == 0) return dp[i][j] = 0;
        if(i == j) return dp[i][j] = arr[i];
        if(dp[i][j] != -1) return dp[i][j];
        int init = arr[i] + getMaxScore(arr, k-1, i+1, j, dp);
        int last = arr[j] + getMaxScore(arr, k-1, i, j-1, dp);
        return dp[i][j] = Math.max(init, last);
    }
}
*/

class Solution {
    public int maxScore(int[]arr, int k) {
        int n = arr.length, sum = 0;
        for(int val:arr) sum += val;
        
        int i = 0, j = 0, curr = 0;
        for(j = 0; j < n-k; j++){
            curr += arr[j];
        }
        
        int min = curr;
        while(j != arr.length){
            curr -= arr[i];
            curr += arr[j];
            j++; i++;
            min = Math.min(min, curr);
        }
        
        return sum-min;
    }
}