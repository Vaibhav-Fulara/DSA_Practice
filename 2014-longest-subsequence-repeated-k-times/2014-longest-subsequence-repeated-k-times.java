class Solution {
    public String longestSubsequenceRepeatedK(String s, int k) {
        int[] map = new int[26];
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            map[ch - 'a']++;
        }
        
        ArrayList<Character> valid = new ArrayList<>();
        for(int i = 0; i < 26; i++){
            if(map[i] >= k){
                valid.add((char)('a' + i));
            }
        }
        
        String ans = "";
        
        LinkedList<String> queue = new LinkedList<>();
        queue.addLast("");
        while(queue.size() > 0){
            String rem = queue.removeFirst();
            for(char ch: valid){
                String next = rem + ch;
                if(isKSub(s, next, k)){
                    queue.addLast(next);
                    ans = next;
                }
            }
        }
        
        return ans;
    }
    
    boolean isKSub(String s, String sub, int k){
        int j = 0;
        int rep = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == sub.charAt(j)){
                j++;
                if(j == sub.length()){
                    rep++; 
                    j = 0;
                    if(rep == k) return true;
                }
            }
        }
        return false;
    }
}