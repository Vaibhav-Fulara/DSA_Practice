class Solution {
    static int[][]dir = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    public int[][] findFarmland(int[][] grid) {
        boolean[][]arr = new boolean[grid.length][grid[0].length];
        ArrayList<int[]>al = new ArrayList<>();
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 1 && !arr[i][j]){
                    int[]bruh = getIsland(arr, grid, i, j);
                    int[]ans = new int[4];
                    ans[0] = i;
                    ans[1] = j;
                    ans[2] = bruh[0];
                    ans[3] = bruh[1];
                    al.add(ans);
                }
            }
        }
        int[][]ans = new int[al.size()][4];
        for(int i=0; i<al.size(); i++) ans[i] = al.get(i);
        return ans;
    }
    
    public int[] getIsland(boolean[][]arr, int[][]grid, int sr, int sc){
        arr[sr][sc] = true;
        int[]ans = {sr,sc};
        for(int[]dirc : dir){
            int row = sr + dirc[0];
            int col = sc + dirc[1];
            if(row >= 0 && row < grid.length && col >= 0 && col < grid[0].length) if(grid[row][col]==1 && !arr[row][col]) {
                int[]bruh = getIsland(arr, grid, row, col);
                if(bruh[0]>ans[0]) ans[0]=bruh[0];
                if(bruh[1]>ans[1]) ans[1]=bruh[1];
            }
        }
        return ans;
    }
}