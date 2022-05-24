class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer>st = new Stack<>();
        int max = 0, curr = -1;
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '(') st.push(i);
            else{
                if(st.size()==0) curr = i;
                else {
                    st.pop();
                    if(st.isEmpty()) max = Math.max(max, i-curr);
                    else max = Math.max(max, i-st.peek());
                    
                }
            }
        }
        return max;
    }
}