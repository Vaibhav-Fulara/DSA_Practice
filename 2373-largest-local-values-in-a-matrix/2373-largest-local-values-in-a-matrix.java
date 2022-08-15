class Solution {
    public int[][] largestLocal(int[][]arr) {
        int n = arr.length;
        int[][]ans = new int[n-2][n-2];
        for(int i=0; i<n-2; i++) {
            for(int j=0; j<n-2; j++) {
                int max = -1;
                for(int m=i; m < i+3; m++) {
                    for(int l = j; l<j+3; l++) {
                        max = Math.max(max, arr[m][l]);                        
                    }
                }
                ans[i][j] = max;
            }
        }
        return ans;
    }
}