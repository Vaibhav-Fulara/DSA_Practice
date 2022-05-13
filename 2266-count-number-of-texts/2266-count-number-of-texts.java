class Solution {
    public int countTexts(String str){
        int n = str.length();
        long[]dp = new long[n+1];
        dp[0] = 1;
        for(int i=1; i<=n; i++){
            char val = str.charAt(i-1);
            dp[i] = dp[i-1];
            if(i>=2 && str.charAt(i-2)==val){
                dp[i] += dp[i-2];
                dp[i] %= 1000000007;
                if(i>=3 && str.charAt(i-3)==val){
                    dp[i] += dp[i-3];
                    dp[i] %= 1000000007;
                    if((val=='7' || val=='9') && i>=4 && str.charAt(i-4)==val){
                        dp[i] += dp[i-4];
                        dp[i] %= 1000000007;
                    }
                }
            }
        }
        return (int)dp[n];
    }
}




// class Solution {
//     int MOD = (int) 1e9 + 7;
//     public int countTexts(String pressedKeys) {
//         int n = pressedKeys.length();
//         int[] dp = new int[n + 1];
//         dp[0] = 1;
        
//         for (int i = 1; i <= n; i++) {
//             char c = pressedKeys.charAt(i - 1);
//             dp[i] = dp[i - 1] % MOD;
            
//             if (i - 2 >= 0 && pressedKeys.charAt(i - 2) == c) {
//                 dp[i] += dp[i - 2];
//                 dp[i] %= MOD;
                
//                 if (i - 3 >= 0 && pressedKeys.charAt(i - 3) == c) {
//                     dp[i] += dp[i - 3];
//                     dp[i] %= MOD;
                    
//                     if ((c == '7' || c == '9') && i - 4 >= 0 && pressedKeys.charAt(i - 4) == c) {
//                         dp[i] += dp[i - 4];
//                         dp[i] %= MOD;
//                     }
//                 }
//             }
//         }
        
//         return dp[n];
//     }
// }