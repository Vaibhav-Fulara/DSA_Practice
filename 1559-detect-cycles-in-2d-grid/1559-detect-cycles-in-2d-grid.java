class Solution {
    int[][]dirs = new int[][]{{-1,0}, {0,-1}, {1,0}, {0,1}};
    public boolean containsCycle(char[][] arr) {
        boolean[][]vis = new boolean[arr.length][arr[0].length];
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                if(vis[i][j]) continue;
                vis[i][j] = true;
                
                boolean bool = check(arr, vis, i, j, -1, -1);
                // System.out.println(bool);
                if(bool)  return true;

                // return false;
            }
            
        }
        return false;
    }
    
    public boolean check(char[][]arr, boolean[][]vis, int i, int j, int m, int n){

        for(int[]dir:dirs){
            int x = i+dir[0], y = j+dir[1];
            if(x == m && y == n) continue;
            if(x >= 0 && y >= 0 && x < arr.length && y<arr[0].length  && arr[x][y] == arr[i][j]){
                // System.out.println(x + " " + y + " " + vis[x][y]);
                if(vis[x][y]) {
                    // System.out.println('t');
                    return true;
                }
                vis[x][y] = true;
                boolean bool = check(arr, vis, x, y, i, j);
                if(bool) return true;
            }
        }

        return false;
    }
}