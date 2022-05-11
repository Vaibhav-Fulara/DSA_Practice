class Solution {
    public int countSquares(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        int[][]ans = new int[n][m];
        int cost = 0;
        for(int i=n-1; i>=0; i--){
            for(int j=m-1; j>=0; j--){
                if(j==m-1) ans[i][j] = arr[i][j];
                else if(i==n-1) ans[i][j] = arr[i][j];
                else{
                    if(arr[i][j] != 0) ans[i][j] = 1 + Math.min(ans[i][j+1], Math.min(ans[i+1][j], ans[i+1][j+1]));
                }
                cost += ans[i][j];
            }
        }
        return cost;
    }
}