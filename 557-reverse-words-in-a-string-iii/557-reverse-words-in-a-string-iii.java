class Solution {
    public String reverseWords(String s) {
        String[]arr = s.split(" ");
        for(int i=0; i<arr.length; i++) {
            String str = arr[i];
            StringBuilder sb = new StringBuilder(str);
            sb = sb.reverse();
            arr[i] = sb.toString();
        }
        StringBuilder sb = new StringBuilder();
        for(String str:arr) {
            sb.append(str);
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
}