class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        for(int i=0; i<s.length(); i++){
            for(int j=i+1; j<=s.length(); j++){
                if(check(s.substring(i,j))) count++;                
            }
        }
        return count;
    }
    public boolean check(String str){
        int l = 0, r = str.length()-1;
        while(l<r) {
            if(str.charAt(l) != str.charAt(r)) return false;
            l++; r--;
        }
        return true;
    }
}