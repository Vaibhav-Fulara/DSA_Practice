// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String line1[] = in.readLine().trim().split("\\s+");
            int N = Integer.parseInt(line1[0]);
            int W = Integer.parseInt(line1[1]);
            String line2[] = in.readLine().trim().split("\\s+");
            int val[] = new int[N];
            for(int i = 0;i < N;i++)
                val[i] = Integer.parseInt(line2[i]);
            String line3[] = in.readLine().trim().split("\\s+");
            int wt[] = new int[N];
            for(int i = 0;i < N;i++)
                wt[i] = Integer.parseInt(line3[i]);
                
            Solution ob = new Solution();
            System.out.println(ob.knapSack(N, W, val, wt));
        }
    }
}// } Driver Code Ends


//User function Template for Java

// Memoisation
/*class Solution{
    static int knapSack(int N, int W, int val[], int wt[]){
        int[][]dp = new int[val.length][W+1];
        for(int[]ar:dp) Arrays.fill(ar, -1);
        return solve(val.length-1, W, val, wt, dp);
    }
    static int solve(int i, int max, int[]val, int[]wt, int[][]dp){
        if(i == 0){
            if(wt[i] <= max) return dp[i][max] = max/wt[i]*val[i];
            return dp[i][max] = 0;
        }
        
        if(dp[i][max] != -1) return dp[i][max];
        
        int pick = -1;
        if(wt[i] <= max) pick = val[i] + solve(i, max-wt[i], val, wt, dp);
        int ignore = solve(i-1, max, val, wt, dp);
        return dp[i][max] = Math.max(pick, ignore);
    }
}*/
    
// Tabulation
/*class Solution{
    static int knapSack(int N, int W, int val[], int wt[]){
        int[][]dp = new int[val.length][W+1];
        for(int i=0; i<val.length; i++){
            for(int max = 0; max<=W; max++){
                if(i == 0){
                    if(wt[i] <= max) dp[i][max] = max/wt[i]*val[i];
                    continue;
                }
                int pick = -1;
                if(wt[i] <= max) pick = val[i] + dp[i][max-wt[i]];
                int ignore = dp[i-1][max];
                dp[i][max] = Math.max(pick, ignore);
            }
        }
        return dp[wt.length-1][W];
    }
}*/

// Space Optimization
class Solution{
    static int knapSack(int N, int W, int val[], int wt[]){
        int[]prev = new int[W+1];
        for(int i=0; i<val.length; i++){
            for(int max = 0; max<=W; max++){
                if(i == 0){
                    if(wt[i] <= max) prev[max] = max/wt[i]*val[i];
                    continue;
                }
                int pick = -1;
                if(wt[i] <= max) pick = val[i] + prev[max-wt[i]];
                int ignore = prev[max];
                prev[max] = Math.max(pick, ignore);
            }
        }
        return prev[W];
    }
}