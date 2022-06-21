// Dp + Backtracking
// Wrong answer as the next numbers wont be able to check for the direction of the currently inspected number
/*
class Solution {
    public int[][] updateMatrix(int[][] arr) {
        
        int[][]dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        boolean[][]vis = new boolean[arr.length][arr[0].length];
        
        // Convert 1 to -1
        
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                if(arr[i][j] == 1) arr[i][j] = -1;
            }
        }
        
        // Traversal for -1 elements
        
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                if(arr[i][j] == -1){
                    getMinDistance(arr, i, j, dirs, vis);
                }
            }
        }
        
        return arr;
    }
    
    public int getMinDistance(int[][]arr, int i, int j, int[][]dirs, boolean[][]vis){
        if(arr[i][j] != -1) return arr[i][j];
        int min = (int)1e5;
        
        vis[i][j] = true;
        for(int[] dir:dirs){
            int x = dir[0] + i;
            int y = dir[1] + j;
            if(x >= 0 && y>=0 && x < arr.length && y <arr[0].length && vis[x][y] == false) 
                min = Math.min( 1 + getMinDistance(arr, x, y, dirs, vis), min);
        }
        vis[i][j] = false;
        
        return arr[i][j] = min;
    }
}
*/

// BFS
class Solution {
    public int[][] updateMatrix(int[][] arr) {
        ArrayDeque<pair>qu = new ArrayDeque<>();
        int step = 0;
        
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                if(arr[i][j] == 0) qu.add(new pair(i, j));
                else arr[i][j] = -1;
            }
        }
        
        int[][]dirs = new int[][] {{-1,0}, {1,0}, {0,-1}, {0,1}};
        
        while(qu.size() != 0){
            int len = qu.size();
            step++;
            for(int k=0; k<len; k++){
                pair p = qu.poll();
                for(int[]dir:dirs){
                    int i = p.x + dir[0];
                    int j = p.y + dir[1];
                    if(i >= 0 && j >= 0 && i<arr.length && j<arr[0].length && arr[i][j] == -1){
                        arr[i][j] = step;
                        qu.add(new pair(i,j));
                    }
                }
            }
        }
        return arr;
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