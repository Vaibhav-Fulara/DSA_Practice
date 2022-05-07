class Solution {
    public boolean find132pattern(int[]arr) {
        int n = arr.length;
        int[]min = new int[n];
        min[0] = arr[0];
        for(int i=1; i<n; i++)  min[i] = Math.min(min[i-1], arr[i]);
        Stack<Integer>st = new Stack<>();
        for(int j=n-1; j>=0; j--){
            while(st.size()>0 && st.peek() <= min[j]) st.pop();
            if(st.size()>0 && st.peek()<arr[j]) return true;
            st.push(arr[j]);
        }
        return false;
    }
}