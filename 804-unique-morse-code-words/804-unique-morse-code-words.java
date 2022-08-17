class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[]arr = new String []{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        
        Set<String>hs = new HashSet<>();
        for(String word:words) {
            StringBuilder sb = new StringBuilder();
            for(char ch:word.toCharArray()) {
                sb.append(arr[ch-'a']);
            }
            hs.add(sb.toString());
        }
        
        return hs.size();
    }
}
