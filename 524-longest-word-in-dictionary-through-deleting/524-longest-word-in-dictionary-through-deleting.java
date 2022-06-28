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