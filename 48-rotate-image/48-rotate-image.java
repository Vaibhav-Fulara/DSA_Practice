class Solution {
    public void rotate(int[][] matrix) {
        transpose(matrix);
        reverse(matrix);
    }
    
    public void transpose(int[][]arr){
        int n = arr.length;
        for(int i=0; i<n; i++){
            for(int j=0; j<n-i-1; j++){
                int temp = arr[i][j];
                arr[i][j] = arr[n-j-1][n-i-1];
                arr[n-j-1][n-i-1] = temp;
            }
        }
    }
    
    public void reverse(int[][]arr){
        int n = arr.length;
        for(int i=0; i<n/2; i++){
            for(int j=0; j<n; j++){
                int temp = arr[i][j];
                arr[i][j] = arr[n-i-1][j];
                arr[n-i-1][j] = temp;
            }
        }
    }
}