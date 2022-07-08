class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        int[]parent1 = new int[n+1];
        int[]parent2 = new int[n+1];
        
        int[]ranks1 = new int[n+1];
        int[]ranks2 = new int[n+1];
        
        for(int i=0; i<=n; i++){
            parent1[i] = i;
            parent2[i] = i;
        }
        
        int ans = 0;
        
        for(int[]edge:edges){
            if(edge[0] == 3){
                int s1 = edge[1];
                int s2 = edge[2];
                
                int l1 = find(s1, parent1);
                int l2 = find(s2, parent1);
                
                if(l1 == l2) ans++;
                else{
                    union(l1, l2, ranks1, parent1);
                    union(l1, l2, ranks2, parent2);
                }
            }
        }
        
        for(int[]edge:edges){
            
            if(edge[0] == 3) continue;
            
            int s1 = edge[1];
            int s2 = edge[2];
            
            if(edge[0] == 1){
                
                int l1 = find(s1, parent1);
                int l2 = find(s2, parent1);
                
                if(l1 == l2) ans++;
                else union(l1, l2, ranks1, parent1);
            } else {
                
                int l1 = find(s1, parent2);
                int l2 = find(s2, parent2);
                
                if(l1 == l2) ans++;
                else union(l1, l2, ranks2, parent2);
            }
        }
        
        boolean bool = false;
        for(int i=1; i<parent1.length; i++){
            if(parent1[i] == i){
                if(bool) return -1;
                bool = true;
            }
        }
        
        bool = false;
        for(int i=1; i<parent2.length; i++){
            if(parent2[i] == i){
                if(bool) return -1;
                bool = true;
            }
        }
        
        return ans;
    }
    
    public void union(int s1, int s2, int[]ranks, int[]parent){
        if(ranks[s1] > ranks[s2]){
            parent[s2] = s1;
        } else if(ranks[s2] > ranks[s1]){
            parent[s1] = s2;
        } else {
            parent[s2] = s1;
            ranks[s1]++;
        }
    }
    
    public int find(int x, int[]parent){
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x], parent);
    }
}