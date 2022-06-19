class Solution {
    public int[] nextGreaterElements(int[]arr) {
        Stack<pair>st = new Stack<>();
        int[]ans = new int[arr.length];
        Arrays.fill(ans, -1);
        for(int j = 0; j<2; j++){
            for(int i=0; i<arr.length; i++){
                while(st.size() > 0 && st.peek().val < arr[i]){
                    pair p = st.pop();
                    ans[p.idx] = arr[i];
                }
                st.add(new pair(arr[i], i));
            }
        }
        return ans;
    }
    public class pair{
        int val;
        int idx;
        pair(int val, int idx){
            this.val = val;
            this.idx = idx;;
        }
    }
}