class Solution {
    public int numDecodings(String s) {
        int[]dp = new int[s.length()+1];
        Arrays.fill(dp, -1);
        return decode(s, dp);
    }
    public int decode(String str, int[]dp){
        if(str.length()==0) return dp[0] = 1;
        if(str.charAt(0) == '0') return 0;
        if(dp[str.length()]!=-1) return dp[str.length()];
        else{
            int ans = 0;
            ans += decode(str.substring(1), dp);
            if(str.length()>1){
                int m = (str.charAt(0)-'0') * 10 + (str.charAt(1)-'0');
                if(m<=26) ans += decode(str.substring(2), dp);
            }
            return dp[str.length()] = ans;
        }
    }
}