class NumMatrix {
    int[][]arr;
    public NumMatrix(int[][] matrix) {
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        arr = new int[m+1][n+1];
        
        for(int i=0; i < m; i++){
            for(int j = 0; j<n; j++) {
                if(i == 0 && j == 0) arr[i][j] = matrix[i][j];
                else if(i==0) arr[i][j] = arr[i][j-1] + matrix[i][j];
                else if(j==0) arr[i][j] = arr[i-1][j] + matrix[i][j];
                else arr[i][j] = arr[i-1][j] + arr[i][j-1] + matrix[i][j] - arr[i-1][j-1];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        if(row1 == 0 && col1 == 0) return arr[row2][col2];
        if(row1 == 0) return arr[row2][col2] - arr[row2][col1-1];
        if(col1 == 0) return arr[row2][col2] - arr[row1-1][col2];
        return arr[row2][col2] - arr[row1-1][col2] - arr[row2][col1-1] + arr[row1-1][col1-1];
    }
}