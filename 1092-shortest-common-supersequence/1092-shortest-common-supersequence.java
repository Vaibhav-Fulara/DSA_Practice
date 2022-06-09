class Solution {
    public String shortestCommonSupersequence(String s1, String s2) {
        int n1 = s1.length(), n2 = s2.length();
        int[][]dp = new int[n1][n2];
        for(int[]arr:dp) Arrays.fill(arr, -1);
        
        int c = getLCS(s1, s2, 0, 0, dp);
        StringBuilder sb = printLCS(dp, s1, s2, c);
        // System.out.println(sb);
        
        int i=0, j=0, k=0;
        
        StringBuilder s = new StringBuilder();
        
        while(i != n1 && j != n2 && k != c){
            if(s1.charAt(i) == sb.charAt(k) && s2.charAt(j) == sb.charAt(k)){
                s.append(s1.charAt(i));
            }
            else if(s1.charAt(i) == sb.charAt(k)){
                char ch = s1.charAt(i);
                while(s2.charAt(j) != ch) s.append(s2.charAt(j++));
                s.append(ch);
            }
            else if(s2.charAt(j) == sb.charAt(k)){
                char ch = s2.charAt(j);
                while(s1.charAt(i) != ch) s.append(s1.charAt(i++));
                s.append(ch);
            }
            else{
                s.append(s1.charAt(i));
                s.append(s2.charAt(j));
                k--;
            }
            k++; i++; j++;
        }
        
        if(i != n1) s.append(s1.substring(i,n1));
        if(j != n2) s.append(s2.substring(j,n2));
        
        return s.toString();
    }
    
    public int getLCS(String s1, String s2, int i, int j, int[][]dp){
        if(i == s1.length() || j == s2.length()) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        if(s1.charAt(i) == s2.charAt(j)) {
            return dp[i][j] = 1 + getLCS(s1, s2, i+1, j+1, dp);
        }
        else return dp[i][j] = Math.max(getLCS(s1, s2, i+1, j, dp), getLCS(s1, s2, i, j+1, dp));
    }
    
    public StringBuilder printLCS(int[][]dp, String s1, String s2, int k){
        StringBuilder sb = new StringBuilder();
        int n = 0, m = 0;
        while(k > 0 && n < dp.length && m < dp[0].length){
            if(s1.charAt(n) == s2.charAt(m)) {
                sb.append(s1.charAt(n));
                k--; m++; n++;
            }
            else if(n != dp.length-1 && (m == dp[0].length-1 || dp[n+1][m] > dp[n][m+1])) n++;
            else m++;
        }
        return sb;
    }
}