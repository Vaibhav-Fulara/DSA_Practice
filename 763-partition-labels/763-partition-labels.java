class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer>hm = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            hm.put(ch, i);
        }

        List<Integer>ans = new ArrayList<>();
        int curr = 0, count = 1;

        while(curr != s.length()){
            char c = s.charAt(curr);
            int idx = hm.get(c);
            for(int i = curr; i <= idx; i++){
                if(hm.get(s.charAt(i)) > idx) idx = hm.get(s.charAt(i));
            }
            ans.add(idx-curr+1);
            curr = idx+1;
        }
        return ans;
    }
}

