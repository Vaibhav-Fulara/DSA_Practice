class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[]arr = new int[primes.length];
        int[]dp = new int[n];
        dp[0] = 1;
        for(int i=1; i<n; i++) {
            int min = Integer.MAX_VALUE;
            for(int k=0; k<arr.length; k++) {
                if(primes[k] * dp[arr[k]] < 0) continue;
                min = Math.min(min, primes[k] * dp[arr[k]]);
            }
            dp[i] = min;
            for(int k=0; k<arr.length; k++) {
                if(min == primes[k] * dp[arr[k]]) arr[k]++;
            }
        }
        return dp[n-1];
    }
}