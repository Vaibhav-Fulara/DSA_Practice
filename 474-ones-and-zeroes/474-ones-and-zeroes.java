class Solution {
    int max = 0;
    public int findMaxForm(String[]arr, int m, int n) {
        int[][][]dp = new int[arr.length+1][m+1][n+1];
        return getAns(arr, 0, m, n, 0, dp);
    }
    public int getAns(String[]arr, int idx, int m, int n, int curr, int[][][]dp){
        if(idx == arr.length)  return 0;
        
        if(dp[idx][m][n] != 0) return dp[idx][m][n];
        
        int zeros = 0, ones = 0;
        for(char ch:arr[idx].toCharArray()){
            if(ch == '1') ones++;
            else zeros ++;
        }
        
        int incl = 0, nincl = 0;
        if(idx <= arr.length-1){
            if(m>=zeros && n>=ones) incl = 1 + getAns(arr, idx+1, m-zeros, n-ones, curr+1, dp);
            nincl = getAns(arr, idx+1, m, n, curr, dp);
        }
        
        return dp[idx][m][n] = Math.max(incl, nincl);
    }
}