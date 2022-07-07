class Solution {
    public int longestBeautifulSubstring(String s) {
        char[]arr = new char[]{'a', 'e', 'i', 'o', 'u'};
        int curr = -1;
        int max = 0, len = 0;
        for(int i=0; i<s.length(); i++){
            if(curr == -1) {
                if(s.charAt(i) == 'a') {
                    curr = 0;
                    len ++;
                }
                continue;
            } else if(curr == 4) {
                if(s.charAt(i) == 'u'){
                    len++;
                } else{
                    max = Math.max(len, max);
                    
                    i--;
                    curr = -1;
                    len = 0;
                }
                continue;
            }else if(s.charAt(i) == arr[curr]){
                len++;
            } else if(s.charAt(i) == arr[curr+1]){
                curr++;
                len++;
            } else {
                i--;
                curr = -1;
                len = 0;
            }
        }
        if(s.charAt(s.length()-1) == 'u') max = Math.max(max, len);
        return max;
    }
}