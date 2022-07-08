class Solution {
    int[][]dirs = {{-1,0},{0,-1},{1,0},{0,1}};
    public boolean exist(char[][]arr, String s) {
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                if(arr[i][j] == s.charAt(0)){
                    boolean[][]vis = new boolean[arr.length][arr[0].length];
                    vis[i][j] = true;
                    if(dfs(arr, s, "" + arr[i][j], i, j, 1, vis)) return true;
                }
            }
        }
        return false;
    }
    public boolean dfs(char[][]arr, String tar, String curr, int i, int j, int k, boolean[][]vis){
        // System.out.println(curr + " " + tar);
        if(curr.equals(tar)) return true;
        for(int[]dir:dirs){
            int x = i+dir[0];
            int y = j+dir[1];
            if(x>=0 && y>=0 && x<arr.length && y<arr[0].length && arr[x][y] == tar.charAt(k) && !vis[x][y]){
                vis[x][y] = true;
                if(dfs(arr, tar, curr + arr[x][y], x, y, k+1, vis)) return true;
                vis[x][y] = false;
            }
        }
        return false;
    }
}