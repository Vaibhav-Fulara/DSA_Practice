class Solution {
    static int[]dp = new int[50];
    
    public int findMinFibonacciNumbers(int k) {
        getFibo(Integer.MAX_VALUE);
        int i=0;
        while(dp[i] <= k) if(dp[i++] == k) return 1;
        return findMinFibonacciNumbers(k-dp[i-1]) + 1;
    }
    
    public void getFibo(int n){
        if(dp[1] != 0) return;
        int i=1;
        while(true){
            if(i==1 || i==2) {
                dp[i] = 1;
                i++;
                continue;
            }
            dp[i] = dp[i-1] + dp[i-2];
            if(dp[i]<0) return;            
            i++;
        }
    }
}