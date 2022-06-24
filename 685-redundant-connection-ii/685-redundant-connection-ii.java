class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        
        int[]inDegree = new int[edges.length+1];
        Arrays.fill(inDegree, -1);
        
        int bl1 = -1, bl2 = -1;
        
        for(int i=0; i<edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            
            if(inDegree[v] == -1){
                inDegree[v] = i;
            } else {
                bl1 = i;
                bl2 = inDegree[v];
                break;
            }
        }
        
        int[]parent = new int[edges.length+1];
        int[]rank = new int[edges.length+1];
        
        for(int i=0; i<parent.length; i++) parent[i] = i;
        
        for(int i=0; i<edges.length; i++){
            if(i == bl1) continue;
            
            int[]edge = edges[i];
            boolean bool = union(edge[0], edge[1], parent, rank);
            if(bool){
                if(bl1 == -1){
                    return edge;
                } else{
                    return edges[bl2];
                }
            }
        }
        
        return edges[bl1];
    }
    
    public int find(int x, int[]parent){
        if(x == parent[x]) return x;
        else return find(parent[x], parent);
    }
    public boolean union(int s1, int s2, int[]parent, int[]rank){
        int s1l = find(s1, parent);
        int s2l = find(s2, parent);
        
        if(s1l != s2l){
            if(rank[s1l] > rank[s2l]){
                parent[s2l] = s1l;
            } else if(rank[s2l] > rank[s1l]){
                parent[s1l] = s2l;
            } else{
                parent[s2l] = s1l;
                rank[s1l]++;
            }
            return false;       // No cycle due to this edge  
        } else return true;     // Indicates that the cycle exists
    }
}