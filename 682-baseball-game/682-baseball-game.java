class Solution {
    public int calPoints(String[] ops) {
        Stack<Integer>st = new Stack<>();
        for(String str:ops){
            if (str.equals("+")){
                int a = st.pop();
                int b = st.peek();
                st.push(a);
                st.push(a+b);
            }
            else if (str.equals("C")) st.pop();
            else if (str.equals("D")) st.push(st.peek()*2);
            else st.add(Integer.parseInt(str));
        }
        int ans = 0;
        while(!(st.isEmpty())) ans+=st.pop();
        return ans;
    }
}