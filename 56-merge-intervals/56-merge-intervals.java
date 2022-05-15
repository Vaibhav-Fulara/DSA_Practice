class Solution {
    public int[][] merge(int[][]arr) {
        Stack<pair> st = new Stack<>();
        Arrays.sort(arr, (a,b)->a[0]-b[0]);
        st.push(new pair(arr[0][0], arr[0][1]));
        for(int i=1; i<arr.length; i++){
            int s2 = arr[i][0];
            int e2 = arr[i][1];
            if(s2 > st.peek().end) {
                st.push(new pair(s2,e2));
                continue;
            }
            
            pair p = st.pop();
            int s1 = p.strt;
            int e1 = p.end;
            
            if(s2 == e1 || e2 >= e1){
                st.push(new pair(s1,e2));
                continue;
            }
            
            st.push(new pair(s1, e1));
        }
        
        int[][]ans = new int[st.size()][2];
        int i=0;
        while(!st.isEmpty()){
            pair p = st.pop();
            ans[i++] = new int[]{p.strt, p.end};
        }
        return ans;
    }
    public class pair{
        int strt;
        int end;
        public pair(int strt, int end){
            this.strt = strt;
            this.end = end;
        }
    }
}