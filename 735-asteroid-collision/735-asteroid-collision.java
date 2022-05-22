class Solution {
    public int[] asteroidCollision(int[] arr) {
        Stack<Integer>st = new Stack<>();        
        for(int i=0; i<arr.length; i++){
            int temp = arr[i];
            if(st.size()==0 || st.peek()*temp > 0 || temp>0){
                st.push(temp);
                continue;
            }
            while(st.size()!=0 && temp < 0 && temp*st.peek()<0){
                int old = st.pop();
                int n1 = Math.abs(old);
                int n2 = Math.abs(temp);
                if(n1 == n2) temp = 0;
                else temp = n1 > n2? old:temp;
            }
            if(temp!=0) st.add(temp);
        }
        int n = st.size();
        int[]ans = new int[n--];
        while(n>=0) ans[n--] = st.pop();
        return ans;
    }
}