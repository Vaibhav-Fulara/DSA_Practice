class Solution {
    public int[][] generateMatrix(int n) {
        int [][] arr = new int[n][n];
        int sr = 0, sc = 0, lr = n-1, lc = n-1, idx = 1;
        while(idx!=n*n+1){
            if(idx!=n*n+1) {for(int i=sc; i<=lc; i++) arr[sr][i] = idx++;  sr++;}
            if(idx!=n*n+1) {for(int i=sr; i<=lr; i++) arr[i][lc] = idx++;  lc--;}
            if(idx!=n*n+1) {for(int i=lc; i>=sc; i--) arr[lr][i] = idx++;  lr--;}
            if(idx!=n*n+1) {for(int i=lr; i>=sr; i--) arr[i][sc] = idx++;  sc++;}
        }
        return arr;
    }
}