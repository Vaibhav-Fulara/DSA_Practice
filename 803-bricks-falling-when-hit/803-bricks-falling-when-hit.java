class Solution {
    public int[] hitBricks(int[][] grid, int[][] hits) {
        int m = grid.length;
        int n = grid[0].length;
        
        // The idea is too first remove all hit bricks from the grid (mark as 2) and then traverse from back
        // resubstituting a perfect brick and then check the change in no. of zero-unioned bricks.
        
        // We mark with 2 as if we din't, we would have ended up substituting bricks in grid places with 0 bricks
        // while traversing back and resubstituting.
        
        // We union elements directly connected to the roof with zero as seen in the unionOfAllNeighbours in the code.
        
        parent = new int[m*n+1];    // m*n elements + roof at index 0
        ranks = new int[m*n+1];     // m*n elements + roof at index 0
        size = new int[m*n+1];      // m*n elements + roof at index 0
        
        for(int i=0; i<parent.length; i++){
            parent[i] = i;
            size[i] = 1;
        }
        
        for(int[]hit:hits) {
            int x = hit[0];
            int y = hit[1];
            if(grid[x][y] == 1){
                grid[x][y] = 2;     // removing the hit brick, if present
            }
        }
        
        for(int i=0; i < m; i++) { 
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 1){    // for each brick, union it with its neighbours and possibly with the roof.
                    unionOfAllNeighbors(grid, i, j, m, n);
                }
            }
        }
        
        int[]res = new int[hits.length];    // array to store the answer
        
        for(int i=hits.length-1; i >= 0; i--) {
            int x = hits[i][0];
            int y = hits[i][1];
            
            // If grid[x][y] == 0, it means there was no brick in the original array at the concerned position.
            // Hence, number of bricks falling would be zero. Hence, we simply continue.
            
            if(grid[x][y] == 2) {
                int bricksInZero = size[find(0)];       // count initial bricks connected to the roof.
                
                grid[x][y] = 1;
                unionOfAllNeighbors(grid, x, y, m, n);
                int newBricksInZero = size[find(0)];    // count final bricks connected to the roof.
                
                if(newBricksInZero > bricksInZero) {
                    res[i] = newBricksInZero - bricksInZero - 1;    // the difference final-initial+1 is the amount of fallen bricks.
                                                                    // we decrement by 1 as we don't have to count the hit brick.
                }
            }
        }
        
        return res;
    }
    
    int[][]dirs = {{-1,0}, {0,-1}, {0,1}, {1,0}};
    public void unionOfAllNeighbors(int[][]grid, int i, int j, int m, int n) {
        int bno = i*n + j + 1;          // 1d box no. for the 2d grid element (add 1 as index 0 is reserved for roof).
        for(int[]dir:dirs) {
            int ni = i + dir[0];
            int nj = j + dir[1];
            
            if(ni >= 0 && nj >=0 && ni < m && nj < n && grid[ni][nj] == 1) {
                int nbno = ni * n + nj + 1;     // 1d box no. for the new 2d grid element.
                union(bno, nbno);               // union hit brick with its earlier neighbors.
            }
        }
        if(i == 0){
            union(bno, 0);                      // if connected to the roof, union with roof.
                                                // (for initially connecting all i=0 elements to the roof).
        }
    }
    
    public int[]parent;             // parent stores the parent of the component
    public int[]ranks;              // ranks stores the rank of the component
    public int[]size;               // size stores the length of the connected component to the given component
    
    public int find(int x){
        if(x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }
    
    public void union(int s1, int s2){      // union by rank, maintaining size
        int l1 = find(s1);
        int l2 = find(s2);
        if(l1 == l2) return;
        if(ranks[l1] > ranks[l2]) {
            parent[l2] = l1;
            size[l1] += size[l2];
        } else if(ranks[l2] > ranks[l1]) {
            parent[l1] = l2;
            size[l2] += size[l1];
        } else {
            parent[l1] = l2;
            size[l2] += size[l1];
            ranks[l2]++;
        }
    }
}