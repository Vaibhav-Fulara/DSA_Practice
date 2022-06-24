class Solution {
    int[]parent;
    int[]rank;
    
    /*  
    
    In this question, we devide each cell into four triangles such that each contains a unique value.
    We use DSU on connected (not / or \ seperated) nodes and convert them into a single set.
    Further, we also connect neighbouring nodes' neighbouring components (see line 41).    
       ________
      |  \ 0 / |
      |   \ /  |
      | 3  X 1 |
      |   / \  |
      |  / 2 \ |
      |________|
    */
    public int regionsBySlashes(String[] grid) {
        
        parent = new int [4 * grid.length * grid.length];       // for storing the parent idx
        rank = new int [4 * grid.length * grid.length];
        
        for(int i=0; i < parent.length; i++){
            parent[i] = i;
        }
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length(); j++){
                
                char ch = grid[i].charAt(j);
                
                int bno = i * grid.length + j;
                
                if(ch != '/'){
                    unionHelper(4 * bno + 0, 4 * bno + 1);
                    unionHelper(4 * bno + 2, 4 * bno + 3);
                }
                
                if(ch != '\\'){
                    unionHelper(4 * bno + 0, 4 * bno + 3);
                    unionHelper(4 * bno + 1, 4 * bno + 2);
                }
                
                if(i > 0){
                    int obno = (i - 1) * grid.length + j;
                    unionHelper(4 * bno + 0, 4 * obno + 2);
                }
                
                if(j > 0){
                    int obno = i * grid.length + (j-1);
                    unionHelper(4 * bno + 3, 4 * obno + 1);
                }
            }
        }
        
        int count = 0;
        for(int i=0; i<parent.length; i++){
            if(parent[i] == i) count++;
        }
        return count;
    }
    
    public int find(int x){
        if(parent[x] == x) return x;
        parent[x] = find(parent[x]);
        return parent[x];
    }
    public void union(int s1l, int s2l){
        if(rank[s1l] > rank[s2l]){
            parent[s2l] = s1l;
        } else if(rank[s2l] > rank[s1l]){
            parent[s1l] = s2l;
        } else{
            parent[s1l] = s2l;
            rank[s2l] ++;
        }
    }
    public void unionHelper(int src, int dest){
        int sl1 = find(src);
        int sl2 =  find(dest);
        
        if(sl1 != sl2){
            union(sl1, sl2);
        }
    }
}