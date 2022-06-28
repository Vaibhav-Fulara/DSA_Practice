class Solution {
    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        int[]arr = new int[cuts.length + 2];
        int t=0;
        arr[t++] = 0;
        for(int val:cuts) arr[t++] = val;
        arr[t] = n;
        
        int[][]dp = new int[arr.length][arr.length];

        for(int i=cuts.length; i>0; i--){
            for(int j = i; j <= cuts.length; j++){
                int min = Integer.MAX_VALUE;
                for(int k = i; k <= j; k++) min = Math.min(min, arr[j+1] - arr[i-1] + dp[i][k-1] + dp[k+1][j]);
                dp[i][j] = min;
            }
        }
        
        return dp[1][cuts.length];
    }
}