class Solution {
    public int findTargetSumWays(int[] a, int target) {        
        int totalSum = 0;
        for(int i: a) totalSum += i;
        
        if (target + totalSum < 0 || (target + totalSum)%2 != 0) return 0;
        int n =a.length;
        int sum = (target + totalSum)/2;
        
        int[] dp=new int[sum+1];
        
        if(a[0] == 0) dp[0] = 2;
        else dp[0] = 1;
        if(a[0] !=0 && a[0] <= sum ) dp[a[0]] = 1;
        
        for(int i = 1; i<n; i++){
            int[] curr=new int[sum+1];
            for(target=0;target<=sum;target++){
                int notPick = dp[target];
                int pick = 0;
                if(target >= a[i])
                    pick = dp[target-a[i]];
                curr[target] = pick+notPick;
            }
            dp=curr;
        }       
        return dp[sum];        
    }
}