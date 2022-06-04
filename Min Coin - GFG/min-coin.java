// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String S = br.readLine().trim();
            String[] S1 = S.split(" ");
            int n = Integer.parseInt(S1[0]);
            int amount  = Integer.parseInt(S1[1]);
            String s = br.readLine().trim();
            String[] s1 = s.split(" ");
            int[] nums = new int[n];
            for(int i = 0; i < s1.length; i++)
                nums[i] = Integer.parseInt(s1[i]);
            Solution ob = new Solution();
            int ans = ob.MinCoin(nums, amount);
            System.out.println(ans);           
        }
    }
}
// } Driver Code Ends


//User function Template for Java

// class Solution{
//     public int MinCoin(int[] nums, int amount){
//         int[][]dp = new int[nums.length][amount+1];
//         for(int[]ar:dp) Arrays.fill(ar, -1);
//         int ans = getMinCoins(nums, amount, 0, dp);
//         return ans >= 1e9? -1:ans;
//     }
//     public int getMinCoins(int[]nums, int amount, int i, int[][]dp){
//         if(i == nums.length-1){
//             if(amount % nums[i] == 0) return dp[i][amount] = amount/nums[i];    
//             // note that it will five zero also when amount == 0
//             return dp[i][amount] = (int)1e9;
//         }
        
//         if(dp[i][amount] != -1) return dp[i][amount];
        
//         int take = (int)1e9;
//         if(amount >= nums[i]) take = 1 + getMinCoins(nums, amount-nums[i], i, dp);
//         int notTake = getMinCoins(nums, amount, i+1, dp);
        
//         return dp[i][amount] = Math.min(take, notTake);
//     }
// }

class Solution{
    public int MinCoin(int[] nums, int tar){
        int[][]dp = new int[nums.length][tar+1];
        for(int i=nums.length-1; i>=0; i--){
            for(int amount = 1; amount <= tar; amount++){
                if(i == nums.length-1){
                    if(amount % nums[i] == 0) dp[i][amount] = amount/nums[i];
                    else dp[i][amount] = (int)1e9;
                    continue;
                }
            
                int take = (int)1e9;
                if(amount >= nums[i]) take = 1 + dp[i][amount-nums[i]];
                int notTake = dp[i+1][amount];
                
                dp[i][amount] = Math.min(take, notTake);
            }
        }
        return dp[0][tar] >= 1e9? -1:dp[0][tar];
    }
}