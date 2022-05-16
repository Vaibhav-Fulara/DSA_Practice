class Solution {
    
    public int[][] insert(int[][] intervals, int[] add) {
        Stack<pair>st = new Stack<>();
        int strt=1;
        int n = intervals.length;
        int t1 = add[0], t2 = add[1];
        int idx = n;
        for(int i=0; i<n; i++){
            int[]arr = intervals[i];
            if(arr[0]>t1) {
                idx = i;
                break;
            }
        }
        
        if(!(idx == 0)) st.push(new pair(intervals[0][0], intervals[0][1]));
        else {st.push(new pair(t1, t2)); strt=0;}
        
       for(int i=strt; i<intervals.length; i++){
           
           if(i==idx){
               if(t1 > st.peek().end) st.push(new pair(t1,t2));
               else {
                   pair p = st.pop();
                   int s1 = p.strt;
                   int e1 = p.end;

                   if(t1 == e1 || t2 >= e1) st.push(new pair(s1,t2));
                   else st.push(new pair(s1, e1));
               }
           }
           
           int s2 = intervals[i][0];
           int e2 = intervals[i][1];
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
        
       if(idx==n){
           if(t1 > st.peek().end) st.push(new pair(t1,t2));
           else {
               pair p = st.pop();
               int s1 = p.strt;
               int e1 = p.end;

               if(t1 == e1 || t2 >= e1) st.push(new pair(s1,t2));
               else st.push(new pair(s1, e1));
           }
        }
       
       int[][]ans = new int[st.size()][2];
        int i=st.size()-1;
        while(!st.isEmpty()){
            pair p = st.pop();
            ans[i--] = new int[]{p.strt, p.end};
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