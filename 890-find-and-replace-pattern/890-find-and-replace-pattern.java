class Solution {
    public List<String> findAndReplacePattern(String[] words, String s) {
        int n = s.length();
        List<String>al = new ArrayList<>();
        for(String word:words) {
            Set<Character>hs = new HashSet<>();
            Map<Character, Character>hm = new HashMap<>();
            for(int i=0; i<=n; i++) {
                
                if(i == n) {al.add(word); break;}
                
                char ch1 = s.charAt(i);
                char ch2 = word.charAt(i);
                
                if(!hm.containsKey(ch1)) {
                    if(hs.contains(ch2))break;
                    hm.put(ch1, ch2);
                    hs.add(ch2);
                }
                
                if(hm.get(ch1) != ch2) break;
            }
        }
        return al;
    }
}