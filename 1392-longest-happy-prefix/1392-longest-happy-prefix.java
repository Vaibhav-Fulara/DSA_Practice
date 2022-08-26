class Solution {
    public String longestPrefix(String s) {
        int len = 0;
        int i=1;
        int[]arr = new int[s.length()];
        
        while(i != arr.length) {
            if(s.charAt(i) == s.charAt(len)) {
                len++;
                arr[i++] = len;
            } else if(len == 0) {
                i++;
            } else {
                len = arr[len-1];
            }
        }
             
        return s.substring(0, arr[arr.length-1]);
    }
}