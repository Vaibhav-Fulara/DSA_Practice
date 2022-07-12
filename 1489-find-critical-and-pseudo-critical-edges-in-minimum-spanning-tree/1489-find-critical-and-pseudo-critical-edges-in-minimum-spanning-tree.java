class Solution {
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        parent = new int[n];
        ranks = new int[n];
        
        for(int i=0; i<n; i++) parent[i] = i;
        
        PriorityQueue<pair>pq = new PriorityQueue<>((a,b) -> a.wt-b.wt);
        for(int[]edge:edges) pq.add(new pair(edge[0], edge[1], edge[2]));
        int minCost = kruskals(pq);
        
        List<List<Integer>>al = new ArrayList<>();
        al.add(new ArrayList<>());
        al.add(new ArrayList<>());
        
        for(int i=0; i<edges.length; i++){
            for(int p=0; p<n; p++) {
                parent[p] = p;
                ranks[p] = 0;
            }
            
            int[]e = edges[i];
            int x = e[0];
            int y = e[1];
            for(int m=0; m<edges.length; m++){
                if(i == m) continue;
                int[]edge = edges[m];
                pq.add(new pair(edge[0], edge[1], edge[2]));
            }
            
            int k = kruskals(pq);
            int par = 0;
            for(int p = 0; p<parent.length; p++) {
                if(parent[p] == p) par++;
            }
            if(par != 1 || k > minCost) {
                al.get(0).add(i);
            } else {
                for(int p=0; p<n; p++) {
                    parent[p] = p;
                    ranks[p] = 0;
                }
                union(x, y);
                
                for(int m=0; m<edges.length; m++){
                    if(i == m) continue;
                    int[]edge = edges[m];
                    pq.add(new pair(edge[0], edge[1], edge[2]));
                }
                
                int l = kruskals(pq) + e[2];
                if(l == minCost) al.get(1).add(i);
            }
        }
        return al;
    }
    
    public int kruskals(PriorityQueue<pair>pq) {
        int minCost = 0;
        while(pq.size() != 0) {
            pair p = pq.remove();
            if(union(p.x, p.y)) minCost += p.wt;
        }
        return minCost;
    }
    
    public class pair{
        int x;
        int y;
        int wt;
        pair(int x, int y, int wt) {
            this.x = x;
            this.y = y;
            this.wt = wt;
        }
    }
    
    int[]parent;
    int[]ranks;
    
    public int find(int x) {
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
    
    public boolean union(int s1, int s2) {
        int l1 = find(s1);
        int l2 = find(s2);
        
        if(l1 == l2) {
            return false;
        } else if(ranks[l1] > ranks[l2]) {
            parent[l2] = l1;
        } else if(ranks[l2] > ranks[l1]) {
            parent[l1] = l2;
        } else {
            parent[l2] = l1;
            ranks[l1]++;
        }
        return true;
    }
}