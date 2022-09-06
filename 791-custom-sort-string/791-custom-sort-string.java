class Solution {
    public String customSortString(String order, String s) {
        int[]arr = new int[26];
        for(char ch:s.toCharArray()) arr[ch -'a']++;
        StringBuilder sb = new StringBuilder();
        for(char ch:order.toCharArray()) {
            int val = arr[ch-'a'];
            for(int i=0; i<val; i++) sb.append(ch);
            arr[ch-'a'] = 0;
        }
        for(int i=0; i<26; i++) {
            char ch = (char)('a' + i);
            int val = arr[ch-'a'];
            for(int v=0; v<val; v++) sb.append(ch);
        }
        return sb.toString();
    }
}