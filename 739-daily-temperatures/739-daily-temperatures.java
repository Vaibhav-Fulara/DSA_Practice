// TC = O(N) + O(n) not O(n^2) as in any case, we dont traverse traversed nodes again
// SC = O(n)
/*
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
*/

class Solution {
    public int[] dailyTemperatures(int[] arr) {
        Stack<Integer>st = new Stack<>();
        int[]ans = new int[arr.length];
        
        for(int i=0; i<arr.length; i++){
            while(st.size()>0 && arr[st.peek()] < arr[i]){
                int idx = st.pop();
                ans[idx] = i-idx;
            }
            st.add(i);
        }
        
        return ans;
    }
}