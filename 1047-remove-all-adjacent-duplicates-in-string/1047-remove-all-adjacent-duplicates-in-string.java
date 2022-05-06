class Solution {
    public String removeDuplicates(String s) {
        StringBuilder sb = new StringBuilder(s);
        int i=1;
        while(i < sb.length()){
            if(i>0 && sb.charAt(i)==sb.charAt(i-1)){
                sb.deleteCharAt(i);
                sb.deleteCharAt(i-1);
                i-=2;
            }
            i++;
        }
        return sb.toString();
    }
}