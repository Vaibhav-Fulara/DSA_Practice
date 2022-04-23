class Solution {
    static int[][]dir = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<Integer>qu = new LinkedList<>();
        int fresh = getOranges(qu, grid);
        int time = 0;
        while(qu.size()!=0){
            int size = qu.size();
            if(fresh == 0) return time;
            time++;
            while(size-- !=0){
                int rem = qu.remove();
                int x = rem/m;
                int y = rem%m;
                for(int[]d:dir){
                    int r = x+d[0];
                    int c = y+d[1];
                    if(r>=0 && c>=0 && r<n && c<m && grid[r][c] == 1){
                        grid[r][c] = 2;
                        qu.add(r*m + c);
                        fresh--;
                    }
                }
            }
        }
        return fresh != 0? -1:time;
    }
    public int getOranges(Queue<Integer>qu, int[][]grid){
        int count = 0;
        int n = grid.length;
        int m = grid[0].length;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]==2) qu.add(i*m + j);
                else if(grid[i][j]==1) count++;
            }
        }
        return count;
    }
}