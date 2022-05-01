class Solution {
    public void setZeroes(int[][]arr) {
        int n = arr.length;
        int m = arr[0].length, k=0;
        while (k < m && arr[0][k] != 0) ++k;
        for(int i=1; i<n; i++) for(int j=0; j<m; j++) if(arr[i][j] == 0) arr[i][0] = arr[0][j] = 0;
        for(int i=1; i<n; i++) for(int j=m-1; j>=0; j--) if(arr[i][0]==0 || arr[0][j]==0) arr[i][j] = 0;
        if(k<m) Arrays.fill(arr[0], 0);
    }
}