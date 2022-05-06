class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<pair>st = new Stack<>();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(st.size()!=0 && st.peek().val==ch){
                int n = st.pop().rep;
                if(n == k-1) continue;
                else st.push(new pair(ch, n+1));
            }
            else st.push(new pair(ch,1));
        }
        String ans = "";
        while(!st.isEmpty()){
            pair p = st.pop();
            for(int i=0; i<p.rep; i++)  ans = p.val + ans;
        }
        return ans;
    }
    public class pair{
        char val;
        int rep;
        pair(){}
        pair(char val, int rep){
            this.val = val;
            this.rep = rep;
        }
    }
}