class Solution {
    public String removeKdigits(String num, int k) {
        StringBuilder sb = new StringBuilder(num);
        int i=0;
        while(i != sb.length()-1){
            if(sb.charAt(i) > sb.charAt(i+1)){
                char ch = sb.charAt(i);
                while(k > 0 && i >= 0 && sb.charAt(i) > sb.charAt(i+1)){
                    sb.deleteCharAt(i--);
                    k--;
                }
                if(k == 0) break;
            }
            i++;
        }
        String s = sb.substring(0, sb.length()-k);
        int idx=0;
        while(idx < s.length() && s.charAt(idx) == '0'){
            idx++;
            continue;
        }
        s = s.substring(idx);
        return s.equals("")? "0":s;
    }
}