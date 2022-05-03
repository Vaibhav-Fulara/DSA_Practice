class Solution {
    public int[][] dics = {{-1,0}, {0,-1}, {1,0}, {0,1}};
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        char[][]arr = new char[n][m];
        for(char[]val:arr) Arrays.fill(val, 'X');
        for(int j=0; j<m; j++){
            if(board[0][j]=='O' && arr[0][j]=='X') getPath(arr, board, 0, j);
            if(board[n-1][j]=='O' && arr[n-1][j]=='X') getPath(arr, board, n-1, j);
        }
        for(int i=0; i<n; i++){
            if(board[i][0]=='O' && arr[i][0]=='X') getPath(arr, board, i, 0);
            if(board[i][m-1]=='O' && arr[i][m-1]=='X') getPath(arr, board, i, m-1);
        }
        for(int j=0; j<arr.length; j++){
            char[]temp = arr[j];
            for(int i=0; i<temp.length; i++) board[j][i] = arr[j][i];
        }
    }
    public void getPath(char[][]arr, char[][]board, int i, int j){
        arr[i][j] = 'O';
        for(int[]dic:dics){
            int x = i+dic[0];
            int y = j+dic[1];
            if(x>=0 && y>=0 && x<arr.length && y<arr[0].length && board[x][y] == 'O' && arr[x][y] == 'X') getPath(arr, board, x, y);
        }
    }
}