// Eulerian path
// O(E)
// PriorityQueue has been used to maintain Lexicographical Order of the itenerary
class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String, PriorityQueue<String>>hm = new HashMap<>();
        for(List<String>ls:tickets){
            if(!hm.containsKey(ls.get(0))) hm.put(ls.get(0), new PriorityQueue<>());
            hm.get(ls.get(0)).add(ls.get(1));
        }
        List<String>al = new ArrayList<>();
        List<String>list = new ArrayList<>();
        dfs(hm, "JFK", al);
        return al;
    }
    public void dfs(Map<String, PriorityQueue<String>>hm, String src, List<String>list){
        PriorityQueue<String>pq = hm.get(src);
        if(pq == null ){
            list.add(0,src);
            return;
        }
        if(pq.size() == 0){
            list.add(0,src);
            hm.remove(src);
            return;
        }
        while(!pq.isEmpty()){
            String s = pq.remove();
            dfs(hm, s, list);
        }
        list.add(0,src);
    }
}