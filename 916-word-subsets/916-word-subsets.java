// Brute TLE O(n*m*word.length)
/*
class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String>al = new ArrayList<>();
        Map<Character, Integer>[]arr = new HashMap[words2.length];
        
        int big = words2[0].length();
        for(int i=0; i<words2.length; i++) {
            String tar = words2[i];
            big = Math.max(big, tar.length());
            Map<Character, Integer>hm = new HashMap<>();
            for(char ch:tar.toCharArray()) {
                if(!hm.containsKey(ch)) hm.put(ch,0);
                hm.put(ch, hm.get(ch)+1);
            }
            arr[i] = hm;
        }
        
        
        Arrays.sort(words2, (a,b) -> b.length()-a.length());
        for(String s:words1) {
            if(s.length() < big) continue;
            Map<Character, Integer>hm1 = new HashMap<>();
            for(char ch:s.toCharArray()) {
                if(!hm1.containsKey(ch)) hm1.put(ch,0);
                hm1.put(ch, hm1.get(ch)+1);
            }
            
            boolean bool = true;
            for(int i=0; i<=arr.length; i++) {
                if(!bool) break;
                if(i == arr.length) {
                    al.add(s);
                    break;
                }
                Map<Character, Integer>map = arr[i];
                if(hm1.size() < map.size()) break;
                for(char key:map.keySet()) {
                    // System.out.println(key);
                    if(!hm1.containsKey(key) || hm1.get(key) < map.get(key)) {
                        bool = false;
                        break;
                    }
                }
            }
        }
        return al;
    }
}
*/

// Optimal
// O(m + n)
class Solution {
    public List<String> wordSubsets(String[] A, String[] B) {
       List<String> result=new ArrayList<>();
        int[] target=new int[26];
        
        for(String word:B){
            int[] temp=new int[26];
            for(char ch:word.toCharArray()){
                temp[ch-'a']++;
                target[ch-'a']=Math.max(target[ch-'a'],temp[ch-'a']);
            }
        }
        
        for(String word:A){
            int[] source=new int[26];
            for(char ch:word.toCharArray()){
                source[ch-'a']++;
            }
            
            if(subset(source,target)){
                result.add(word);
            }
        }
        
        return result;
    }
    
    private boolean subset(int[] parent,int[] child){
        for(int i=0;i<26;i++){
            if(parent[i]<child[i]) return false;
        }
        return true;
    }
}