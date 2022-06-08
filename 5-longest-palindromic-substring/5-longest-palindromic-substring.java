class Solution {
    public String longestPalindrome(String s) {
        int strt = 0, end = 0;
        for(int i=0; i<s.length(); i++){
            int l1 = checkFromMid(s,i,i);
            int l2 = checkFromMid(s,i,i+1);
            int len = Math.max(l1, l2);
            if(len > end - strt){
                strt = i - (len-1)/2;
                end = i + len/2;
            }
        }
        return s.substring(strt, end+1);
    }
    public int checkFromMid(String s, int i, int j){
        if(s == null || i > j) return 0;
        
        int len = 0;
        while( i>=0 && j<s.length() && s.charAt(i) == s.charAt(j)) {
            if(i == j) len += 1;
            else len += 2;
            i--; j++;
        }
        // System.out.println(len);
        return len;
    }
}