// Backtracking O(4^n) TLE
/*
class Solution {
    int[][]dirs = {{-1,0}, {0,-1}, {1,0}, {0,1}};
    public int swimInWater(int[][] grid) {
        
        boolean[][]vis = new boolean[grid.length][grid[0].length];
        vis[0][0] = true;
        
        return swim(grid, 0, 0, vis, 0);
    }
    public int swim(int[][]arr, int i, int j, boolean[][]vis, int time){
        if(i == arr.length-1 && j == arr[0].length-1) return 0;
        int min = 2501;
        for(int[]dir:dirs){
            int x = i+dir[0];
            int y = j+dir[1];
            if(x >= 0 && y >= 0 && x < arr.length && y < arr[0].length && vis[x][y] == false){
                vis[x][y] = true;
                int timex = Math.max(time, Math.max(arr[i][j], arr[x][y]));
                int jump = swim(arr, x, y, vis, timex);
                jump = jump + (timex > time ? timex - time : 0);
                min = Math.min(min, jump);
                vis[x][y] = false;
            }
        }
        return min;
    }
}
*/

// Dijkstra-type BFS O(m*n) AC
class Solution {
    int[][]dirs = {{-1,0}, {0,-1}, {1,0}, {0,1}};
    public int swimInWater(int[][] arr) {
        boolean[][]vis = new boolean[arr.length][arr[0].length];
        vis[0][0] = true;
        
        PriorityQueue<pair>pq = new PriorityQueue<>((a,b) -> a.cost - b.cost);
        pq.add(new pair(0,0,arr[0][0]));
        
        int[][]shortest = new int[arr.length][arr[0].length];
        
        while(pq.size() != 0){
            pair p = pq.remove();
            
            int i = p.x, j = p.y;
            arr[i][j] = p.cost;
            
            if(i == arr.length-1 && j == arr[0].length-1) return arr[i][j];
            
            for(int[]dir:dirs){
                int x = i+dir[0], y = j+dir[1];
                if(x >= 0 && y >= 0 && x<arr.length && y<arr[0].length && vis[x][y] == false){
                    vis[x][y] = true;
                    pq.add(new pair(x, y, Math.max(p.cost, arr[x][y])));
                }
            }
        }
        return -1;
    }
    public class pair{
        int x;
        int y;
        int cost;
        public pair(int x, int y, int cost){
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }
}