// Brute TLE O(words.length^2 * words[i].length * 2)
/*
class Solution {
    public List<List<Integer>> palindromePairs(String[]arr) {
        List<List<Integer>>al = new ArrayList<>();
        for(int i=0; i<arr.length; i++) {
            for(int j=0; j<arr.length; j++) {
                if(i == j) continue;
                if(isPalindrome(arr[i] + arr[j])) {
                    List<Integer>a = new ArrayList<>();
                    a.add(i);
                    a.add(j);
                    al.add(new ArrayList<>(a));
                }
            }
        }
        return al;
    }
    public boolean isPalindrome(String s) {
        int i=0, j=s.length()-1;
        while(i < j) if(s.charAt(i++) != s.charAt(j--)) return false;
        return true;
    }
}
*/

class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        HashMap<String,Integer> wordMap = new HashMap<>();
        Set<Integer> set = new TreeSet<>();
        int n = words.length;
        
        for(int i=0;i<n;i++){
            wordMap.put(words[i],i);
            set.add(words[i].length());
        }
        
        List<List<Integer>> ans = new ArrayList<>();
        
        for(int i=0;i<n;i++){
            int length = words[i].length();
            
            if(length ==1){
                if(wordMap.containsKey("")){
                    ans.add(Arrays.asList(i, wordMap.get("")));
                    ans.add(Arrays.asList(wordMap.get(""), i));
                }
                continue;
            }
            String reverse= new StringBuilder(words[i]).reverse().toString();
            if(wordMap.containsKey(reverse) && wordMap.get(reverse) != i)
                ans.add(Arrays.asList(i,wordMap.get(reverse)));
            
            for(Integer k:set){
                if(k==length)
                    break;
                if(isPalindrome(reverse,0,length-1-k)){
                    String s1 = reverse.substring(length-k);
                    if(wordMap.containsKey(s1))
                        ans.add(Arrays.asList(i,wordMap.get(s1)));
                }
                
                if(isPalindrome(reverse,k,length-1)){
                    String s2 = reverse.substring(0,k);
                    if(wordMap.containsKey(s2))
                        ans.add(Arrays.asList(wordMap.get(s2),i));
                }
            }
        }
        return ans;
    }
    
    private boolean isPalindrome(String s, int left, int right){
        while(left<right)
            if(s.charAt(left++)!=s.charAt(right--))
                return false;
        return true;
    }
}