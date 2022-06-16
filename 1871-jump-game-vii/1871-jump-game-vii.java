// TLE
/*
class Solution {
    public boolean canReach(String s, int min, int max) {
        if(s.charAt(s.length()-1) != '0') return false;
        
        boolean[]dp = new boolean[s.length()];
        dp[s.length() - 1] = true;
        
        for(int i = dp.length-2; i >= 0; i--){
            int reachmax = Math.min(max, s.length() - i - 1);
            for(int m = reachmax; m >= min; m--){
                if(i+m >= s.length()) break;
                if(s.charAt(i+m) == '0' && dp[i+m]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[0];
    }
}
*/

class Solution{
    public boolean canReach(String s, int min, int max) {
        if(s.charAt(s.length()-1) != '0') return false;
        
        int far = 0;
        
        Queue<Integer>qu = new ArrayDeque<>();
        qu.add(0);
        
        while(qu.size()!=0){
            int i = qu.poll();
            if(i == s.length()-1) return true;
            for(int m = Math.max(i + min, far); m <= Math.min(s.length()-1, i+max); m++){
                if(s.charAt(m) == '0'){
                    qu.add(m);
                }
            }
            far = Math.min(s.length()-1, i+max+1);
        }
        return false;
    }
}