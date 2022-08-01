class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        Map<Character, Integer>hm1 = new HashMap<>();
        Map<Character, Integer>hm2 = new HashMap<>();
        for(int i=0; i<s.length(); i++) {
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);
            if(!hm1.containsKey(ch1)) hm1.put(ch1, 0);
            if(!hm2.containsKey(ch2)) hm2.put(ch2, 0);
            hm1.put(ch1, hm1.get(ch1)+1);
            hm2.put(ch2, hm2.get(ch2)+1);
        }
        for(char ch:hm1.keySet()) {
            if(!hm2.containsKey(ch)) return false;
            if(hm1.get(ch) - hm2.get(ch) != 0) {
                System.out.println(hm1.get(ch) + "   " + hm2.get(ch));
                return false;
            }
        }
        return true;
    }
}