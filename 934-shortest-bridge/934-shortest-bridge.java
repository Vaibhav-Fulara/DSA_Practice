class Solution {
    int[][]dirs = {{-1,0}, {0,-1}, {1,0}, {0,1}};
    public int shortestBridge(int[][]arr) {
        int x = -1, y = -1;
        
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                if(arr[i][j] == 1) {
                    x = i; y = j;
                    break;
                }
            }
        }
        
        boolean[][]vis = new boolean[arr.length][arr[0].length];
        Queue<pair>qu = new ArrayDeque<>();
        qu.add(new pair(x,y));
        vis[x][y] = true;
        
        traverse(arr, vis, qu, x, y);
        
        int steps = 0;
        while(qu.size()!=0){
            steps++;
            int n = qu.size();
            for(int v=0; v<n; v++){
                pair p = qu.poll();
                int i = p.x, j = p.y;
                for(int[]dir:dirs){
                    x = i+dir[0];
                    y = j+dir[1];
                    if(x >= 0 && y>=0 && x<arr.length && y<arr[0].length && !vis[x][y]){
                        if(arr[x][y] == 1) return steps-1;
                        vis[x][y] = true;
                        qu.add(new pair(x,y));
                    }
                }
            }
        }
        return -1;
    }
    
    public void traverse(int[][]arr, boolean[][]vis, Queue<pair>qsf, int i, int j){
        Queue<pair>qu = new ArrayDeque<>();
        qu.add(new pair(i, j));
        
        while(qu.size()!=0){
            pair p = qu.remove();
            i = p.x;
            j = p.y;
            for(int[]dir:dirs){
                int x = i+dir[0];
                int y = j+dir[1];
                if(x >= 0 && y>=0 && x<arr.length && y<arr[0].length && !vis[x][y] && arr[x][y] == 1){
                    vis[x][y] = true;
                    qu.add(new pair(x,y));
                    qsf.add(new pair(x,y));
                }
            }
        }
    }
    
    public class pair{
        int x;
        int y;
        pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}