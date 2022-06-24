class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int[]parent = new int[edges.length+1];
        int[]rank = new int[edges.length+1];
        
        for(int i=0; i<parent.length; i++) parent[i] = i;
        
        for(int[]edge:edges){
            int s1 = find(edge[0], parent);
            int s2 = find(edge[1], parent);
            
            if(s1 == s2) return edge;
            
            union(s1, s2, parent, rank);
        }
        
        return new int[]{-1,-1};
    }
    
    public int find(int x, int[]parent){
        if(x == parent[x]) return x;
        else return find(parent[x], parent);
    }
    
    public void union(int s1, int s2, int[]parent, int[]rank){
        if(rank[s1] > rank[s2]){
            parent[s2] = s1;
        } else if(rank[s2] > rank[s1]){
            parent[s1] = s2;
        } else{
            rank[s2]++;
            parent[s2] = s1;
        }
    }
}