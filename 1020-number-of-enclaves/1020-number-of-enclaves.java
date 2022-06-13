class Solution {
    boolean flag = true;
    public int numEnclaves(int[][]arr) {
        int[][]dirs = {{-1, 0}, {0, -1}, {1, 0}, {0,1}};
        boolean[][] visited = new boolean[arr.length][arr[0].length];
        int ans = 0;
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                if(arr[i][j] == 1 && visited[i][j] == false){
                    int val = dfs(arr, i, j, dirs, visited);
                    if(flag) ans += val;
                    flag = true;
                }
            }
        }
        return ans;
    }
    
    public int dfs(int[][]arr, int i, int j, int[][]dirs, boolean[][]vis){
        if(i >= arr.length || j >= arr[0].length || i < 0 || j < 0){
            flag = false; 
            return 0;
        }
        else if(arr[i][j] == 0 || vis[i][j] == true) return 0;
        
        vis[i][j] = true;
        int ans = 0;
        
        for(int[]dir:dirs){
            int x = i + dir[0];
            int y = j + dir[1];
            ans += dfs(arr, x, y, dirs, vis);
        }
        
        return 1+ans;
    }
}
