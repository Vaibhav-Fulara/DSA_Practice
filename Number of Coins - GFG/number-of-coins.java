// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int v = sc.nextInt();
                    int m = sc.nextInt();
                    int coins[] = new int[m];
                    for(int i = 0;i<m;i++)
                        coins[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minCoins(coins, m, v));
                }
        }
}    // } Driver Code Ends


class Solution{
	public int minCoins(int coins[], int M, int V){ 
	    int[]dp = new int[V+1];
	    Arrays.fill(dp, Integer.MAX_VALUE - 1);
	    
	    for(int i=0; i<=V; i++){
	        for(int j=0; j<M; j++){
	            if(i == coins[j]) {
	                dp[i] = 1;
	                continue;
	            }
    	        if(i > coins[j]){
    	            int val = dp[i-coins[j]] + 1;
    	            if(val< dp[i]) dp[i] = val;
    	        } 
	        }
	    }
	    return dp[V] == Integer.MAX_VALUE-1? -1:dp[V];
	}
}