// Sorting
// O(n log n)

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


// No sorting
// O(n*k)
class Solution{
    public String findLongestWord(String s, List<String> d) {
        String longest = "";
        for (String dictWord : d) {
            int i = 0;
            for (char c : s.toCharArray()) 
                if (i < dictWord.length() && c == dictWord.charAt(i)) i++;

            if (i == dictWord.length() && dictWord.length() >= longest.length()) 
                if (dictWord.length() > longest.length() || dictWord.compareTo(longest) < 0)
                    longest = dictWord;
        }
        return longest;
    }
}