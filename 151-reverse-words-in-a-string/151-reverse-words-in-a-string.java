class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String[]arr = s.split(" ");
        for(int i=arr.length-1; i>=0; i--) {
            String str = arr[i];
            if(str.length() != 0) sb.append(str + " ");
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
}