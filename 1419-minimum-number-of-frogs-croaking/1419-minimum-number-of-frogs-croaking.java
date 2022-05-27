class Solution {
    public int minNumberOfFrogs(String s) {
        Map<Character, Integer>hm = new HashMap<>();
        String str = "croa";
        int count = 0;
        for(char ch:str.toCharArray()) hm.put(ch, 0);
        for(char ch:s.toCharArray()){
            if(ch == 'c') hm.put(ch, hm.get(ch)+1);
            else if(ch == 'r'){
                if(hm.get('c') == 0) return -1;
                hm.put(ch, hm.get(ch)+1);
            }
            else if(ch == 'o'){
                if(hm.get('r') == 0) return -1;
                hm.put(ch, hm.get(ch)+1);
            }
            else if(ch == 'a'){
                if(hm.get('o') == 0) return -1;
                hm.put(ch, hm.get(ch)+1);
            }
            else{
                for(char c:str.toCharArray()){
                    if(hm.get(c) == 0) return -1;
                    count = Math.max(count,hm.get(c));
                    hm.put(c,hm.get(c)-1);
                }
            }
        }
        for(char ch:str.toCharArray()) if(hm.get(ch) != 0) return -1;
        return count;
    }
}