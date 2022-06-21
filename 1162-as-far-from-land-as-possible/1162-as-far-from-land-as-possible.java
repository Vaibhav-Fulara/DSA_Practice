class Solution {
    public int maxDistance(int[][] arr) {
        boolean[][]vis = new boolean[arr.length][arr[0].length];
        Queue<pair>qu = new ArrayDeque<>();
        int[][]dirs = new int[][]{{-1,0}, {0,-1}, {1,0}, {0,1}};
        
        for(int i=0; i<arr.length; i++){
            for ( int j=0; j<arr[0].length; j++){
                if(arr[i][j] == 1) {
                    qu.add(new pair(i,j));
                    vis[i][j] = true;
                }
            }
        }
        
        if(qu.size()==0 || qu.size() == arr.length * arr[0].length) return -1;
        
        int step = 0;
        while(qu.size()!=0){
            step++;
            int len = qu.size();
            for(int k=0; k<len; k++){
                pair p = qu.remove();
                // System.out.println(p.x+" "+p.y);
                for(int[]dir:dirs){
                    int x = p.x + dir[0];
                    int y = p.y + dir[1];
                    if(x>=0 && y>=0 && x<arr.length && y<arr[0].length && vis[x][y] == false) {
                        vis[x][y] = true;
                        qu.add(new pair(x,y));
                    }
                }
            }
            // System.out.println();
        }
        return step-1;
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