class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer>hm = new HashMap<>();
        for(char ch:magazine.toCharArray()) {
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);
        }
        for(char ch:ransomNote.toCharArray()) {
            if(!hm.containsKey(ch) || hm.get(ch) == 0) return false;
            hm.put(ch, hm.get(ch)-1);
        }
        return true;
    }
}