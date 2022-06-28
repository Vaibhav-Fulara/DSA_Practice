class Solution {
    public String longestWord(String[] words) {
        
        Arrays.sort(words, (a,b) -> {
            if(a.length() == b.length()) return a.compareTo(b);
            return b.length()-a.length();
        });
        
        if(words[words.length-1].length() != 1) return "";
        
        Set<String>hs = new HashSet<>();
        for(String s:words) hs.add(s);
        for(String s:words){
            for(int i=1; i <= s.length(); i++){
                if(!hs.contains(s.substring(0,i))) break;
                if(i == s.length()) return s;
            }
        }
        return "";
    }
}