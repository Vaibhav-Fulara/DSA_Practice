class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        boolean[][]dp = new boolean[s.length()][s.length()];
        for(int i=0; i<s.length(); i++){
            for(int j=i; j<s.length(); j++){
                if(check(s, i, j, dp)) count++;                
            }
        }
        return count;
    }
    public boolean check(String str, int l, int r, boolean[][]dp){
        while(l<r) {
            if(dp[l][r] == true) return true;
            if(str.charAt(l) != str.charAt(r)) return false;
            l++; r--;
        }
        return dp[l][r] = true;
    }
}