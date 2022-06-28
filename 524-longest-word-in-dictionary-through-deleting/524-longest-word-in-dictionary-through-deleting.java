// Sorting
/*
class Solution {
    public String findLongestWord(String s, List<String> dict) {
        Collections.sort(dict);
        int len = 0;
        String word = "";
        
        for(String w:dict){
            int i = 0, j = 0;
            while(i < s.length() && j < w.length()){
                if(s.charAt(i) == w.charAt(j)){
                    i++; j++;
                }
                else i++;
            }
            
            if(j == w.length() && w.length() > len){
                len = w.length();
                word = w;
            }
        }
        
        return word;
    }
}
*/

class Solution {
    public String findLongestWord(String s, List<String> d) {
        String res="";
        for (String c: d)
            if ((c.length()>res.length() || c.length()==res.length() && c.compareTo(res)<0) && isSubseq(c, s)) res=c;
        return res;
    }
    public boolean isSubseq(String a, String b){
        int i=-1, j=-1;
        while (++i<a.length()) if ((j=b.indexOf(a.charAt(i), j+1))==-1) return false;
        return true;
    }
}