class Solution {
    int min = Integer.MAX_VALUE;
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(grid[0][0] == 1 || grid[n-1][n-1] == 1) return -1;
        int[][] dirs = {{1,1}, {1,0}, {0,1}, {1,-1}, {-1,1}, {-1,0}, {0,-1}, {-1,-1}};
        Queue<int[]>qu = new LinkedList<>();
        qu.add(new int[]{0,0,1});
        grid[0][0] = 1;
        while(qu.size()!=0){
            int size = qu.size();
            while(size-- >0){
                int[]pair = qu.poll();
                if(pair[0] == n-1 && pair[1] == n-1) return pair[2];
                for(int[]dir:dirs){
                    int x = pair[0] + dir[0];
                    int y = pair[1] + dir[1];
                    if(x>=0 && y>=0 && x<n && y<n && grid[x][y]!=1){
                        qu.add(new int[]{x, y, pair[2]+1});
                        grid[x][y] = 1;
                    }
                }
            }
        }
        return -1;
    }
}