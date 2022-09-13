class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>>ans = new ArrayList<>();
        solve(ans, new ArrayList<>(), s, 0);
        return ans;
    }
    public void solve(List<List<String>>ans, List<String>al, String s, int lo) {
        if(lo == s.length()) {
            ans.add(new ArrayList<>(al));
            return;
        }
        for(int i=lo+1; i<=s.length(); i++) {
            if(isPalindrome(s.substring(lo, i))) {
                al.add(s.substring(lo,i));
                solve(ans, al, s, i);
                al.remove(al.size()-1);
            }
        }
    }
    public boolean isPalindrome(String s) {
        int i=0, j = s.length()-1;
        while(i < j) {
            if(s.charAt(i++) != s.charAt(j--)) return false;
        }
        return true;
    }
}