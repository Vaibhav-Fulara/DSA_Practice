class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>>hm = new HashMap<>();
        List<List<String>>ans = new ArrayList<>();
        for(String s:strs){
            String sorted = sort(s);
            if(!hm.containsKey(sorted)) hm.put(sorted, new ArrayList<>());
            hm.get(sorted).add(s);
        }
        for(String key:hm.keySet()){
            List<String>al = new ArrayList<>();
            for(String s:hm.get(key)) al.add(s);
            ans.add(new ArrayList<>(al));
        }
        return ans;
    }
    
    public String sort(String s){
        int[]letters = new int[26];
        for(char c:s.toCharArray()) letters[c-'a'] ++;
        StringBuilder ans = new StringBuilder();
        for(int i=0; i<26; i++){
            for(int j = 0; j<letters[i]; j++){
                ans.append(i+'a');
            }
        }
        return ans.toString();
    }
}