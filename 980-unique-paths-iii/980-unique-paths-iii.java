class Solution {
    public int uniquePathsIII(int[][]arr) {
        int n = arr.length, m = arr[0].length;
        int empty = n*m, sr = 0, sc = 0, er = 0, ec = 0;
            
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(arr[i][j] != 0){
                    empty--;
                    if(arr[i][j] == 1) {sr = i; sc = j; empty++;}
                    else if(arr[i][j] == 2) {er = i; ec = j;}
                }
            }
        }
        
        int[][]dirs = {{-1, 0}, {1,0}, {0, -1}, {0,1}};
        return getPaths(arr, sr, sc, er, ec, empty, dirs);
    }
    public int getPaths(int[][]arr, int sr, int sc, int er, int ec, int empty, int[][]dirs){
        if(sr == er && sc == ec) {
            if(empty == 0) return 1;
            return 0;
        }
        
        int ans = 0;
        for(int[]dir:dirs){
            int x = sr + dir[0];
            int y = sc + dir[1];
            
            arr[sr][sc] = -1;
            if(x >= 0 && y >= 0 && x < arr.length && y<arr[0].length){
                if(arr[x][y] != -1){
                    ans += getPaths(arr, x, y, er, ec, empty-1, dirs);
                }
            }
            arr[sr][sc] = 0;
        }
        return ans;
    }
}