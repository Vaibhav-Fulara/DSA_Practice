class Solution {
    public int countVowelStrings(int n) {
        int[][]dp = new int[5][n+1];
        return getCount(dp, n, 0);
    }
    public int getCount(int[][]dp, int n, int idx){
        if(n==0) return dp[idx][n] = 1;
        if(n<0 || idx>4) return 0;
        if(dp[idx][n]!=0) return dp[idx][n];
        else{
            int count = 0;
            count += getCount(dp, n-1, idx);
            count += getCount(dp, n, idx+1);
            return dp[idx][n] = count;
        }
    }
}