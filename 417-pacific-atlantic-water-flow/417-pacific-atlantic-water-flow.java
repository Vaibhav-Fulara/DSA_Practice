class Solution {
    public int [][]dirs = {{-1, 0}, {0,-1}, {1,0}, {0,1}};
    public List<List<Integer>> pacificAtlantic(int[][] arr) {
        List<List<Integer>>al = new ArrayList<>();
        for(int i=0; i<arr.length; i++) {
            for(int j=0; j<arr[0].length; j++) {
                if(bfs(arr, i, j)) {
                    List<Integer>a = new ArrayList<>();
                    a.add(i); a.add(j);
                    al.add(new ArrayList<>(a));
                }
            }
        }
        return al;
    }
    public boolean bfs(int[][]arr, int i, int j) {
        Queue<pair>qu = new ArrayDeque<>();
        boolean b1 = false;
        boolean b2 = false;
        qu.add(new pair(i, j));
        boolean[][]vis = new boolean[arr.length][arr[0].length];
        vis[i][j] = true;
        while (!(b1 && b2) && !qu.isEmpty()) {
            pair p = qu.remove();
            if(p.x == 0 || p.y == 0) b1 = true;
            if(p.x == arr.length-1 || p.y == arr[0].length-1) b2 = true;
            for(int[]dir:dirs) {
                int x = p.x + dir[0];
                int y = p.y + dir[1];
                if(x < 0||y < 0||x >= arr.length||y >= arr[0].length||arr[x][y] > arr[p.x][p.y]) continue;
                if(!vis[x][y]) {
                    vis[x][y] = true;
                    qu.add(new pair(x,y));
                }
            }
        }
        return b1 && b2;
    }
    public class pair {
        int x;
        int y;
        public pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}