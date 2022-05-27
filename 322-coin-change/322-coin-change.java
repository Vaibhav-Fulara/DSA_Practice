class Solution {
    public int coinChange(int[] coins, int V) {
        if(V == 0) return 0;
        int M = coins.length;
        int[]dp = new int[V+1];
	    Arrays.fill(dp, Integer.MAX_VALUE);
	    
	    for(int i=0; i<=V; i++){
	        for(int j=0; j<M; j++){
	            if(i == coins[j]) {
	                dp[i] = 1;
	                continue;
	            }
    	        if(i > coins[j]){
    	            int val = dp[i-coins[j]];
    	            if(val < dp[i]) dp[i] = val + 1;
    	        } 
	        }
	    }
	    return dp[V] == Integer.MAX_VALUE? -1:dp[V];
	}
}