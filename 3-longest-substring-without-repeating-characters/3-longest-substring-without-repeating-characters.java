/*
    BRUTE
    O(N3)/O(N)
*/

// class Solution {
//     public int lengthOfLongestSubstring(String s) {
//         int max = 0;
//         for(int i=0; i<s.length(); i++){
//             for(int j=i+1; j<=s.length(); j++){
//                 String str = s.substring(i,j);
//                 if(check(str)) max = Math.max(str.length(), max);
//             }
//         }
//         return max;
//     }
    
//     public boolean check(String str){
//         Set<Character>hs = new HashSet<>();
//         for(char ch:str.toCharArray()){
//             if(hs.contains(ch)) return false;
//             hs.add(ch);
//         }
//         return true;
//     }
// }


/* 
    SLIGHTLY OPTIMIZED
    O(2N)/O(N)
*/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character>hs = new HashSet<>();
        int l = 0, r = 0, max = 0;
        for(char ch:s.toCharArray()){
            while(hs.contains(ch)){
                hs.remove(s.charAt(l));
                l++;
            }
            hs.add(ch);
            r++;
            max = Math.max(max, r-l);
        }
        return max;
    }
}