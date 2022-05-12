class Solution {
    public void solveSudoku(char[][] board) {
        getSS(board, 0, 0, board.length);
    }
    public boolean getSS(char[][]arr, int r, int c, int n){
        if( c == n ) {r++; c=0;}
        if(r == n) return true;
        if (arr[r][c] != '.') return getSS(arr, r, c+1, n);
        for(char i='1'; i<='9'; i++){
            if(isValid(i, arr, r, c)) {
                arr[r][c] = i;
                if(getSS(arr, r, c+1, n)) return true;
                arr[r][c] = '.';
            }
        }
        return false;
    }
    public boolean isValid(char value, char[][]board, int row, int col){
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == value) return false; 
            if (board[row][i] == value) return false;
        }
        int boxRow = row / 3;
        int boxCol = col / 3;
        for (int i = boxRow * 3; i < (boxRow + 1) * 3; i++) {
            for (int j = boxCol * 3; j < (boxCol + 1) * 3; j++) {
                if (board[i][j] == value) return false;
            }
        }
        return true;
    }
}