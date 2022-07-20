// LCS: TLE
// TC: O(m*n*k) where m = s.length(), n = length of biggest word in words, k = words.length
/*
class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        int ans = 0;
        for(String word:words){
            Integer[][]dp = new Integer[s.length()][word.length()];
            
            int n = getLcs(s, word, 0, 0, dp);
            if(n == word.length()) ans++;
        }
        return ans;
    }
    public int getLcs(String s1, String s2, int i, int j, Integer[][]dp) {
        if(i == s1.length() || j == s2.length()) return 0;
        if(dp[i][j] != null) return dp[i][j];
        
        int max = Integer.MIN_VALUE;
        if(s1.charAt(i) == s2.charAt(j)) {
            max = 1 + getLcs(s1, s2, i+1, j+1, dp);
        }
        max = Math.max(max, Math.max(getLcs(s1, s2, i, j+1, dp), getLcs(s1, s2, i+1, j, dp)));
        return dp[i][j] = max;
    }
}
*/

class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        Set<String>hs = new HashSet<>();
        Set<String>ab = new HashSet<>();
        int count = 0;
        for(String word:words) {
            if(hs.contains(word)) {
                count++;
                continue;
            } else if(ab.contains(word)) {
                continue;
            }
            
            int i=0, j=0;
            while(j < s.length() && i < word.length()) {
                if(word.charAt(i) == s.charAt(j)) {
                    i++;
                }
                j++;
            }
            if(i == word.length()){
                // System.out.println(word);
                hs.add(word);
                count++;
            } else ab.add(word);
        }
        return count;
    }
}