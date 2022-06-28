class Solution {
    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        int[]arr = new int[cuts.length + 2];
        int i=0;
        arr[i++] = 0;
        for(int val:cuts) arr[i++] = val;
        arr[i] = n;
        
        int[][]dp = new int[arr.length][arr.length];
        for(int[]ar:dp) Arrays.fill(ar, -1);        
        
        return partition(1, cuts.length, arr, dp);
    }
    public int partition(int i, int j, int[]arr, int[][]dp){
        if(i > j) return 0;
        if(dp[i][j] != -1)  return dp[i][j];
        
        int min = Integer.MAX_VALUE;
        
        for(int k = i; k <= j; k++){
            min = Math.min(min, arr[j+1] - arr[i-1] + partition(i, k-1, arr, dp) + partition(k+1, j, arr, dp));
        }
        
        return dp[i][j] = min;
    }
}