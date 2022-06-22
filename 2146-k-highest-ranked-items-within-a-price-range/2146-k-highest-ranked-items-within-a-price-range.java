class Solution {
    public List<List<Integer>> highestRankedKItems(int[][] grid, int[] pricing, int[] start, int k) {
        List<List<Integer>>ans = new ArrayList<>();
        
        boolean[][]vis = new boolean[grid.length][grid[0].length];
        vis[start[0]][start[1]] = true;
        
        ArrayDeque<pair>qu = new ArrayDeque<>();
        qu.add(new pair(start[0], start[1]));
        
        PriorityQueue<pair>pq = new PriorityQueue<>((a,b) -> {
            if(a.dist == b.dist && a.price == b.price && a.x == b.x) return a.y-b.y;
            if(a.dist == b.dist && a.price == b.price) return a.x - b.x;
            if(a.dist == b.dist) return a.price - b.price;
            return a.dist - b.dist;
        });
        
        int dist = 0;
        int[][]dirs = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
        
        while(qu.size() != 0){
            int len = qu.size();
            for(int q=0; q<len; q++){
                pair p = qu.poll();
                int i = p.x, j = p.y;
                
                if(grid[i][j] >= pricing[0] && grid[i][j] <= pricing[1]){
                    pq.add(new pair(i, j, dist, grid[i][j]));
                }

                for(int[]dir:dirs){
                    int m = i+dir[0];
                    int n = j+dir[1];
                    if(m >= 0 && m < grid.length && n >= 0 && n < grid[0].length && grid[m][n] != 0 && !vis[m][n]){
                        vis[m][n] = true;
                        qu.add(new pair(m,n));
                    }
                }
            }
            dist++;
        }
        
        
        while(pq.size()!=0 && k>0){
            pair p = pq.remove();
            List<Integer>al = new ArrayList<>();
            al.add(p.x);
            al.add(p.y);
            ans.add(new ArrayList<>(al));
            k--;
        }
        
        return ans;
    }
    public class pair{
        int x;
        int y;
        int dist;
        int price;
        pair(int x, int y){
            this.x = x;
            this.y = y;
        }
        pair(int x, int y, int dist, int price){
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.price = price;
        }
    }
}