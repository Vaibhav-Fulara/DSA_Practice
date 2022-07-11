class Solution {
    public List<Boolean> areConnected(int n, int threshold, int[][] queries) {
        parent = new int[n+1];
        ranks = new int[n+1];
        
        List<Boolean>al = new ArrayList<>();
        
        if(threshold == 0) {
            for(int i=0; i<queries.length; i++) al.add(true);
            return al;
        }
        
        for(int i=0; i<parent.length; i++) parent[i] = i;
        
        for(int div = threshold+1; div <=n; div++){
            for(int m = 1; div*m <=n; m++){
                union(div, div*m);
            }
        }
        
        for(int[]query:queries){
            int n1 = query[0];
            int n2 = query[1];
            al.add(find(n1) == find(n2));
        }
        
        return al;
    }
    
    int[]parent;
    int[]ranks;
    
    public int find(int x){
        if(parent[x] == x) return x;
        parent[x] = find(parent[x]);
        return parent[x];
    }
    
    public void union(int s1, int s2){
        int l1 = find(s1);
        int l2 = find(s2);
        if(ranks[l1] > ranks[l2]){
            parent[l2] = l1;
        } else if(ranks[l2] > ranks[l1]){
            parent[l1] = l2;
        } else {
            parent[l2] = l1;
            ranks[l2]++;
        }
    }
}