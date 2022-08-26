class Solution {
    public String shortestPalindrome(String s) {
        String str = s + '^' + new StringBuilder(s).reverse().toString();
        int[]lps = new int[str.length()];
        int len = 0, i=1;
        while(i < lps.length) {
            if(str.charAt(i) == str.charAt(len)) {
                len++;
                lps[i++] = len;
            } else if(len == 0) {
                i++;
            } else {
                len = lps[len-1];
            }
        }
        return new StringBuilder(s.substring(lps[lps.length-1])).reverse().toString() + s;
    }
}

/*
a a c e c a a a
0 1 0 0 0 1 2 0

a b c d
0 0 0 0

a a c a a d a a e a a c a a d a a f
0 1 0 1 2 0 1 2 0 1 2 3 4 5 6 7 8 0
*/