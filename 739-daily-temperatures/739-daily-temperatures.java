class Solution {
    public int[] dailyTemperatures(int[] arr) {
        Stack<pair>st = new Stack<>();
        int[]ans = new int[arr.length];
        
        for(int i=0; i<arr.length; i++){
            while(st.size()>0 && st.peek().val < arr[i]){
                pair p = st.pop();
                ans[p.idx] = i-p.idx;
            }
            st.add(new pair(arr[i], i));
        }
        
        return ans;
    }
    public class pair{
        int val;
        int idx;
        pair(int val, int idx){
            this.val = val;
            this.idx = idx;
        }
    }
}