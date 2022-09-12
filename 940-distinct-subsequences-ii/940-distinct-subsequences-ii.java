class Solution {
    public int distinctSubseqII(String s) {
        int big = 1000000007;
        int[]arr = new int[26];
        long[]dp = new long[s.length() + 1];
        arr[s.charAt(0)-'a'] = 1;
        dp[0] = 1;
        dp[1] = 2;
        for(int i=2; i<=s.length(); i++) {
            char ch = s.charAt(i-1);
            dp[i] = (dp[i-1]*2) % big;
            if(arr[ch-'a'] != 0) {
                dp[i] = (dp[i] - dp[arr[ch-'a'] - 1] + big) % big;
            }
            arr[ch-'a'] = i;
        }
        return (int)((dp[s.length()]-1) % big);
    }
}