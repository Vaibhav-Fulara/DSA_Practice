class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>>ans = new ArrayList<>();
        getPalindrome(ans, 0, s, new ArrayList<>());
        return ans;
    }
    public void getPalindrome(List<List<String>>ans, int lo, String s, List<String>al){
        if(lo == s.length()){
            ans.add(new ArrayList(al));
            return;
        }
        for(int i=lo; i<s.length(); i++){
            String curr = s.substring(lo, i+1);
            if(palindrome(curr)){
                al.add(curr);
                getPalindrome(ans, i+1, s, al);
                al.remove(al.size()-1);
            }
        }
    }
    public boolean palindrome(String str){
        int i=0, j=str.length()-1;
        while(i<j)  if(str.charAt(i++) != str.charAt(j--)) return false;
        return true;
    }
}