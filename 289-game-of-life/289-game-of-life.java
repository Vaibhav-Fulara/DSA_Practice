class Solution {
    public void gameOfLife(int[][] board) {
        int n = board.length;
        int m = board[0].length;
        int[][] ans = new int[n][m];
        for(int r = 0; r < n; r++){
            for(int c = 0; c < m; c++){
                int live = helper(board, r-1, c-1) + helper(board, r-1, c) + helper(board, r-1, c+1) + helper(board, r, c+1) + helper(board, r+1, c+1) + helper(board, r+1, c) +                     helper(board, r+1, c-1) + helper(board, r, c-1);
                if(board[r][c] == 1) ans[r][c] = (live < 2 || live > 3) ? 0 : 1;
                else ans[r][c] = (live == 3) ? 1 : 0;
            }
        }
        for(int r = 0; r < n; r++)  board[r] = ans[r].clone();  
    }
    public int helper(int[][] board, int r, int c){
        if( r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] == 0 ) return 0;
        return 1;
    }
}