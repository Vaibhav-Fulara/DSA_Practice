class Solution {
    public String largestPalindromic(String num) {
        Map<Integer, Integer>hm = new HashMap<>();
        for(char ch:num.toCharArray()) {
            int val = ch-'0';
            hm.put(val, hm.getOrDefault(val, 0) + 1);
        }
        
        int single = -1;
        PriorityQueue<pair>pq = new PriorityQueue<>((a,b) -> a.val-b.val);
        for(int key:hm.keySet()) {
            if(hm.get(key) % 2 != 0) {
                single = Math.max(single, key);
                hm.put(key, hm.get(key)-1);
            }
            if(hm.get(key) != 0) pq.add(new pair(key, hm.get(key)));
        }
        
        int i=0;
        StringBuilder sb = new StringBuilder();
        if(single != -1) sb.append(single);
        
        
        while(!pq.isEmpty()) {
            pair p = pq.poll();
            if(pq.isEmpty() && p.val == 0) continue;
            int val = p.rep / 2;
            for(int k = 0; k<val; k++) {
                sb.insert(0, p.val);
                sb.append(p.val);
            }
        }
        
        
        String s = sb.toString();
        if(s.equals("")) return "0";
        return s;
    }
    public class pair {
        int val;
        int rep;
        public pair (int val, int rep) {
            this.val = val;
            this.rep = rep;
        }
    }
}