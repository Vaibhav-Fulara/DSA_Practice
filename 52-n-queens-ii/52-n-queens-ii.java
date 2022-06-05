class Solution {
    public int totalNQueens(int n) {
        char[][]arr = new char[n][n];
        for(char[]val:arr) Arrays.fill(val, '.');
        
        return solveBoard(arr, n, 0);
    }
    
    public int solveBoard(char[][]arr, int n, int i){
        if(i == n) return 1;
        
        int ans = 0;
        
        for(int j=0; j<n; j++){
            if(isValid(arr, n, i, j)) {
                arr[i][j] = 'Q';
                ans += solveBoard(arr, n, i+1);
                arr[i][j] = '.';
            }
        }
        return ans;
    }
    
    public boolean isValid(char[][]arr, int n, int row, int col){
        for(int i=0; i<row; i++) if(arr[i][col] == 'Q') return false;
        for(int i=row, j = col; i>=0 && j>=0; i--, j--) if(arr[i][j] == 'Q') return false;
        for(int i=row, j=col; i>=0 && j<n; i--, j++) if(arr[i][j] == 'Q') return false;
        return true;
    }
}