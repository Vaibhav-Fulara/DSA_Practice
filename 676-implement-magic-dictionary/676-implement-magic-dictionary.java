class MagicDictionary {
    Map<Integer, List<String>>hm;
    public MagicDictionary() {
        hm = new HashMap<>();
    }
    
    public void buildDict(String[] dict) {
        for(String s:dict){
            if(!hm.containsKey(s.length())) hm.put(s.length(), new ArrayList<String>());
            hm.get(s.length()).add(s);
        }
    }
    
    public boolean search(String s) {
        List<String>list = hm.get(s.length());
        if(list == null) return false;
        for(String word:list){
            int i=0;
            boolean bool = false;
            while(i < s.length()){
                if(s.charAt(i) != word.charAt(i)){
                    if(bool) break;
                    bool = true;
                }
                if(i == s.length()-1 && bool) return bool;
                i++;
            }
        }
        return false;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */