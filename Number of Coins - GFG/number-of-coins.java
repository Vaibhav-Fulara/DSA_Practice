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
	    Arrays.fill(dp, -1);
	    
	    int evaluate =  getMinCoins(coins, V, dp);
	    
	    return evaluate == Integer.MAX_VALUE? -1:evaluate;
	} 
	public int getMinCoins(int[]arr, int tar, int[]dp){
	    if(dp[tar] != -1) return dp[tar];
	    int minCoins = Integer.MAX_VALUE - 1;
	    for(int ele:arr){
	        if(tar == ele) return dp[tar] = 1;
	        int curr = Integer.MAX_VALUE;
	        if(tar > ele) curr = getMinCoins(arr,tar-ele,dp);
	        minCoins = Math.min(minCoins, curr);
	    }
	    return dp[tar] =minCoins + 1;
	}
}