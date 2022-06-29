class Solution {
    public int minCut(String s) {
        int dp[] = new int[s.length()];
        Arrays.fill(dp,-1);
        return solve(0,s.length(),s,dp);
    }
    
    
    public int solve(int i,int n,String s,int []dp){
        if(i==n || isPalindrome(s,i,n-1)) return 0;
        
        if(dp[i] != -1) return dp[i];
        
        int minCost = Integer.MAX_VALUE;
        for(int j=i;j<n;j++){
            if(isPalindrome(s,i,j)){
                int cost =  1+solve(j+1,n,s,dp);
                minCost = Math.min(cost,minCost);
            }
        }
        return dp[i] = minCost;
    }
    
    public boolean isPalindrome(String s,int i,int j){
        while(i<j){
            if(s.charAt(i++)!=s.charAt(j--)) return false;
        }
        return true;
    }
}