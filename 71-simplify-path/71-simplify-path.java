class Solution {
    public String simplifyPath(String path) {
        String[]arr = path.split("/");
        Stack<String>st = new Stack<>();
        for(String s:arr) {
            if(s.length() == 0 || s.equals(".")) {
                continue;
            } else if (s.equals("..")) {
                if(!st.isEmpty())st.pop();
            } else {
                st.add(s);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(String s:st) {
            sb.append('/' + s);
        }
        if(sb.length() == 0) sb.append('/');
        return sb.toString();
    }
}