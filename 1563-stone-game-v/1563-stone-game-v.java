class Solution {
    public int stoneGameV(int[]arr) {
        int n = arr.length;
        Integer[][]dp = new Integer[n][n];
        return solve(arr, 0, n-1, dp);
    }
    public int solve(int[]arr, int strt, int end, Integer[][]dp) {
        if(strt == end) return 0;
        
        if(dp[strt][end] != null) return dp[strt][end];
        
        int sum = 0;
        for(int k = strt; k <= end; k++) sum += arr[k];
        // System.out.println(sum);
        int curr = 0;
        int ans = Integer.MIN_VALUE;
        double tar = (double)sum/2;
        
        for(int i = strt; i < end; i++) {
            curr += arr[i];
            // System.out.println(curr + " " + sum);
            if(curr >= tar) {
                ans = Math.max(ans, sum - curr + solve(arr, i+1, end, dp));
            } 
            if(curr <= tar){
                ans = Math.max(ans, curr + solve(arr, strt, i, dp));
            }
        }
        
        return dp[strt][end] = ans;
    }
}