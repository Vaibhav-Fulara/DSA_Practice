class Solution {
    public int digArtifacts(int n, int[][] artifacts, int[][] dig) {
        boolean[][]arr = new boolean[n][n];
        for(int[]d:dig) arr[d[0]][d[1]] = true;
        int count = 0;
        for(int[]art:artifacts) {
            int sr = art[0];
            int sc = art[1];
            int er = art[2];
            int ec = art[3];
            
            boolean bool = true;
            for(int i=sr; i<=er; i++) {
                for(int j=sc; j<=ec; j++) {
                    if(!arr[i][j]) {
                        bool = false;
                        break;
                    }
                }
                if(!bool) break;
            }
            if(bool) count++;
        }
        return count;
    }
}