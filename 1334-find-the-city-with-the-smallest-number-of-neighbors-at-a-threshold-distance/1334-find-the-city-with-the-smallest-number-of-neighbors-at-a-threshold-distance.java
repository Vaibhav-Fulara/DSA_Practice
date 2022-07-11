class Solution {
    public int findTheCity(int n, int[][] edges, int threshold) {
        int[][]arr = new int[n][n];
        
        for(int[]ar:arr) Arrays.fill(ar,-1);
        
        for(int[]edge:edges) {
            int i = edge[0], j = edge[1], wt = edge[2];
            arr[i][j] = wt;
            arr[j][i] = wt;
        }
        
        
        for(int k=0; k<n; k++) {
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    if(arr[i][k] == -1) {
                        continue;
                    } else if (arr[k][j] == -1) {
                        continue;
                    } else if(arr[i][j] == -1) {
                        arr[i][j] = arr[i][k] + arr[k][j];
                    } else {
                        arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
                    }
                }
            }
        }
        
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr.length; j++){
                // System.out.print(arr[i][j] + " ");
            }
            // System.out.println();
        }
        
        int minN = Integer.MAX_VALUE;
        int idx = 0;
        
        for(int i=0; i<n; i++){
            int count = 0;
            for(int j=0; j<n; j++){
                if(i == j) continue;
                if(arr[i][j] != -1 && arr[i][j] <= threshold) {
                    count ++;
                }
            }
            // System.out.println(i + " " + count);
            if(count <= minN) {
                minN = count;
                idx = i;
            }
        }
        
        return idx;
    }
}