class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());        
        int n = words.length;
        int[] dp = new int[n];
        dp[0] = 1;
        int max = 1;
        
        for(int i=1; i < n; i++){
            dp[i] = 1;
            String currWord = words[i];
            for(int j=0; j < i; j++){
                String prevWord = words[j];
                if((currWord.length() - prevWord.length() == 1) && 
                   (prevWord.length() == lcs(prevWord, currWord)))
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }

    int lcs(String prev, String curr){
        int p = prev.length();
        int c = curr.length();
        int i=0, j=0;
        while(i < p && j < c){
            if(prev.charAt(i) == curr.charAt(j))
                i++;
            j++;
        }
        return i;
    }    
}