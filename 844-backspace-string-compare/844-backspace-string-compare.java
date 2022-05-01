class Solution {
    public boolean backspaceCompare(String s, String t) {
        StringBuilder sb1 = new StringBuilder(s);
        StringBuilder sb2 = new StringBuilder(t);
        for(int i=0; i<sb1.length(); i++){
            if(sb1.charAt(i)=='#'){
                if(i!=0) {sb1.deleteCharAt(i-1); sb1.deleteCharAt(i-1);i-=1;}
                else sb1.deleteCharAt(i);
                i--;
            }
        }
        
        for(int i=0; i<sb2.length(); i++){
            if(sb2.charAt(i)=='#'){
                if(i!=0) {sb2.deleteCharAt(i-1); sb2.deleteCharAt(i-1); i--;}
                else sb2.deleteCharAt(i);
                i--;
            }
        }
        
        String s1 = sb1.toString();
        String s2 = sb2.toString();
        return s1.equals(s2);
    }
}