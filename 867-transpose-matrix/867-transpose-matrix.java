class Solution {
    public int[][] transpose(int[][]arr) {
        int n = arr.length;
        int m = arr[0].length;
        
        int[][]ans = new int[m][n];
        for(int i=0; i < n; i++) for(int j=0; j < m; j++) ans[j][i] = arr[i][j];        
        return ans;
    }
}