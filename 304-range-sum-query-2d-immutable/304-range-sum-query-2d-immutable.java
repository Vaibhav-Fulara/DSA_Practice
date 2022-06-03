class NumMatrix {
    int[][]arr, mat;
    public NumMatrix(int[][] matrix) {
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        arr = new int[m][n];
        mat = matrix;
        
        for(int i=0; i < m; i++){
            int sum = 0;
            for(int j = 0; j<n; j++) {
                sum += matrix[i][j];
                arr[i][j] = sum;
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for(int i=row1; i <= row2; i++){
            sum += mat[i][col1] + arr[i][col2]-arr[i][col1];
        }
        return sum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */