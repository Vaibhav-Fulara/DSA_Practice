class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String, PriorityQueue<String>>hm = new HashMap<>();
        for(List<String>ls:tickets){
            if(!hm.containsKey(ls.get(0))) hm.put(ls.get(0), new PriorityQueue<>());
            hm.get(ls.get(0)).add(ls.get(1));
        }
        Stack<String>st = new Stack<>();
        List<String>list = new ArrayList<>();
        dfs(hm, "JFK", st);
        while(!st.isEmpty()){
            list.add(st.pop());
        }
        return list;
    }
    public void dfs(Map<String, PriorityQueue<String>>hm, String src, Stack<String>st){
        PriorityQueue<String>pq = hm.get(src);
        if(pq == null ){
            st.push(src);
            return;
        }
        while(!pq.isEmpty()){
            String s = pq.remove();
            dfs(hm, s, st);
        }
        st.push(src);
    }
}