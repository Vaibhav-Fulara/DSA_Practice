class Solution {
    public int removePalindromeSub(String s) {
        if(s.length() == 0) return 0;
        return isPalindrome(s)?1:2;
    }
    public boolean isPalindrome(String s){
        int n = s.length();
        for(int i=0; i<n/2; i++) if(s.charAt(i) != s.charAt(n-i-1)) return false;
        return true;
    }
}