class Solution {
    public int minCut(String s) {
        int[]dp = new int[s.length()];
        Arrays.fill(dp, -1);
        
        return getPartition(s, 0, dp)-1;
    }
    
    public int getPartition(String s, int i, int[]dp){
        if(i == s.length()) return 0;
        if(isPalindrome(s.substring(i, s.length()))) return 1;
        
        if(dp[i] != -1) return dp[i];
        
        int min = Integer.MAX_VALUE;
        for(int j=i+1; j<=s.length(); j++){
            if(isPalindrome(s.substring(i, j))){
                min = Math.min(min, 1 + getPartition(s, j, dp));
            }
        }
        return dp[i] = min;
    }
    
    public boolean isPalindrome(String s){
        for(int i=0; i<s.length()/2; i++){
            if(s.charAt(i) != s.charAt(s.length()-1-i)) return false;
        }
        return true;
    }
}