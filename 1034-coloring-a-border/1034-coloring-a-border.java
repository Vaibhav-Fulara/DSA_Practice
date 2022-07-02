class Solution {
    public int[][] colorBorder(int[][] arr, int row, int col, int color) {
        Queue<pair>qu = new LinkedList<>();
        qu.add(new pair(row, col));
        
        int[][]dirs = {{-1,0}, {0,-1}, {0,1}, {1,0}};
        boolean[][]vis = new boolean[arr.length][arr[0].length];
        vis[row][col] = true;
        int og = arr[row][col];
        
        int[][]ans = new int[arr.length][arr[0].length];
        for(int i=0; i<arr.length; i++) for(int j=0; j<arr[0].length; j++) ans[i][j] = arr[i][j];
        
        while(qu.size()!=0){
            pair p = qu.poll();
            int x = p.x;
            int y = p.y;
            if(x == 0 || x == arr.length-1 || y == 0 || y == arr[0].length-1){
                ans[x][y] = color;
            } else {
                if(arr[x+1][y] != og || arr[x-1][y] != og 
                   || arr[x][y+1] != og || arr[x][y-1] != og){
                    // System.out.println(x+" "+y +" "+ arr[x+1][y] +" "+ arr[x-1][y] + " " + arr[x][y+1] + " " + arr[x][y-1]);
                    ans[x][y] = color;
                }
            }
            
            for(int[]dir:dirs){
                int i = x + dir[0];
                int j = y + dir[1];
                if(i>=0 && j>=0 && i<arr.length && j<arr[0].length 
                   && vis[i][j] == false && arr[i][j] == og){
                    vis[i][j] = true;
                    qu.add(new pair(i, j));
                }
            }
        }
        return ans;
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