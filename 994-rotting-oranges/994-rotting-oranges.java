class Solution {
    public int init(Queue<pair>qu, int[][]arr){
        int fresh = 0;
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                if(arr[i][j] == 1) fresh++;
                else if(arr[i][j] == 2) qu.add(new pair(i, j));
            }
        }
        return fresh;
    }    
    public class pair{
        int x;
        int y;
        pair(){};
        pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    static int[][]dir = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    
    public int orangesRotting(int[][] grid) {
        Queue<pair>qu = new LinkedList<>();
        int fresh = init(qu, grid);
        
        if(fresh == 0) return 0;
        
        int time = 0;
        while(qu.size()!=0){
            int size = qu.size();
            
            while(size-- >0){
                pair temp = qu.remove();
                int x = temp.x;
                int y = temp.y;  
                
                if(grid[x][y] == 1){
                    grid[x][y] = 2;
                    fresh--;
                }
                
                if(fresh==0) return time;   
                
                for(int[]d:dir){
                    int r = x + d[0];
                    int c = y + d[1];
                    if(r>=0 && r<grid.length && c>=0 && c<grid[0].length && grid[r][c]==1) qu.add(new pair(r,c));
                }
            }
            time++;
        }
        return fresh == 0? time:-1;
    }
}