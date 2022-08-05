// O(nlogn)

class Solution {
    public int findMinArrowShots(int[][]arr) {
        
        Arrays.sort(arr, (a,b) -> {
            return a[0] < b[0] ? -1:1;
        });
        
        Stack<pair>st = new Stack<>();
        
        for(int i=0; i<arr.length; i++) {
            if(st.isEmpty() || st.peek().right < arr[i][0]) {
                st.add(new pair(arr[i][0], arr[i][1]));
            } else {
                pair p = st.pop();
                st.add(new pair(arr[i][0], Math.min(p.right, arr[i][1])));
            }
        }
        return st.size();
    }
    
    public class pair{
        int left;
        int right;
        public pair(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }
}
