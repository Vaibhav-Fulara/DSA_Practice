class Solution {
    List<String>ls = new ArrayList<>();
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Set<String>hs = new HashSet<>();
        for(String word:words) hs.add(word);
        for(String word:words) {
            hs.remove(word);
            solve(word, hs, 0, 0, 0);
            hs.add(word);
        }       
        return ls;
    }
    public void solve(String s, Set<String>hs, int i, int j, int n){
        if(j == s.length()){
            if(!hs.contains(s.substring(i, j))) return;
            if(n >= 1) ls.add(s);
            return;
        }
        if(hs.contains(s.substring(i, j))){
            solve(s, hs, j, j, n+1);
            if(ls.contains(s)) return;
        }
        solve(s, hs, i, j+1, n);
    }
}