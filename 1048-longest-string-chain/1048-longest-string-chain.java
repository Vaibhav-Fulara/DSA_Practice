class Solution {
    public int longestStrChain(String[] arr) {
        int max = 1;
        
        Arrays.sort(arr, (a,b)->{
            return a.length()-b.length();
        });
        
        int[]dp = new int[arr.length];
        Arrays.fill(dp,1);
        
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<i; j++){
                if(compare(arr[j], arr[i]) && dp[j] + 1 > dp[i])  dp[i] = dp[j] + 1;
            }
            if(dp[i] > max) max = dp[i];
        }
        return max;
    }
            
    public boolean compare(String s1, String s2){
        if(s1.length() + 1 != s2.length()) return false;
        int i=0, j=0, count = 0;
        
        while (i < s1.length()){
            if(j == s2.length()) return false;
            if(s1.charAt(i) == s2.charAt(j)) {
                i++;
                j++;
            }
            else {
                count++;
                j++;
            }
        }
        
        return count <=1;  
    }
}