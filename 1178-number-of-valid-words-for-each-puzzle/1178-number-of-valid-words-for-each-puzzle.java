class Solution {
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        int[]arr = new int[words.length];
        int[]query = new int[puzzles.length];
        List<Integer>al = new ArrayList<>();
        
        for(int i=0; i<words.length; i++) {
            String s = words[i];
            int val = 0;
            for(char ch:s.toCharArray()) {
                int n = ch-'a';
                int mask = 1 << (n);
                val |= mask;
            }
            arr[i] = val;
        }
        
        for(int i=0; i<puzzles.length; i++) {
            String s = puzzles[i];
            int val = 0;
            for(char ch:s.toCharArray()) {
                int n = ch-'a';
                int mask = 1 << (n);
                val |= mask;
            }
            query[i] = val;
        }
        
        for(int i=0; i<query.length; i++) {
            int n = 0;
            
            int peek = 0;
            int m = puzzles[i].charAt(0)-'a';
            int mask = 1 << (m);
            peek |= mask;
            
            for(int j=0; j<arr.length; j++) {
                if((query[i] & arr[j]) == arr[j] && (peek & arr[j]) == peek) n++;
            }
            al.add(n);
        }
        
        return al;
    }
}