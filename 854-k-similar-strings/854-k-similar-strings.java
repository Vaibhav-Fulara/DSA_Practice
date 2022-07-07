class Solution {
    public int kSimilarity(String s1, String s2) {
        HashSet<String> vis = new HashSet<>();
        LinkedList<String> queue = new LinkedList<>();
        
        queue.addLast(s1);
        int level = 0;
        vis.add(s1);
        while(queue.size() > 0){
            int sz = queue.size();
            for(int q = 0; q < sz; q++){
                String s = queue.removeFirst();
                
                if(s.equals(s2)) return level;
                
                
                int idx = -1;
                for(int i = 0; i < s.length(); i++){
                    if(s.charAt(i) != s2.charAt(i)){
                        idx = i;
                        break;
                    }
                }

                if(idx != -1){
                    for(int j = idx + 1; j < s.length(); j++){
                        if(s.charAt(j) == s2.charAt(idx)){
                            String str = swap(s, idx, j);
                            if(!vis.contains(str)){
                                queue.addLast(str);
                                vis.add(str);
                            }
                        }
                    }
                }
            }
            
            level++;
        }
        return -1;
    }
    
    public String swap(String s, int i, int j){
        StringBuilder sb = new StringBuilder(s);
        
        char chi = sb.charAt(i);
        char chj = sb.charAt(j);
        sb.setCharAt(i, chj);
        sb.setCharAt(j, chi);
        
        return sb.toString();
    }
}