// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String str = br.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.LongestRepeatingSubsequence(str);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    public int LongestRepeatingSubsequence(String str){
        Set<Character>hs = new HashSet<>();
        int j = -1;
        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            
            if(hs.contains(ch)){
                j = i;
                // System.out.println(ch + " " + j);
                break;
            }
            hs.add(ch);
        }
        if(j == -1) return 0;
        String s = str.substring(j);
        int [][] dp = new int [str.length()][s.length()];
        for(int[]ar:dp) Arrays.fill(ar, -1);
        // System.out.println(str + " " + s);
        int n = str.length()-s.length();
        return getLCS(str, s, 0, 0, dp, n);
    }
    public int getLCS(String s1, String s2, int i, int j, int[][]dp, int n){
        if(i == s1.length() || j == s2.length()) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        if(i != j + n && s1.charAt(i) == s2.charAt(j)) return dp[i][j] = 1 + getLCS(s1, s2, i+1, j+1, dp, n);
        else return dp[i][j] = Math.max(getLCS(s1, s2, i+1, j, dp, n), getLCS(s1, s2, i, j+1, dp, n));
    }
}
