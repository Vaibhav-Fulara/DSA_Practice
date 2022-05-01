class Solution {
    public void setZeroes(int[][]arr) {
        int n = arr.length;
        int m = arr[0].length;
        List<Integer>rows = new ArrayList<>();
        List<Integer>cols = new ArrayList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(arr[i][j] == 0) {
                    cols.add(j);
                    rows.add(i); 
                }
            }
        }
        for(int i:rows) for(int j=0; j<arr[0].length; j++) arr[i][j] = 0;
        for(int i:cols) for(int j=0; j<arr.length; j++) arr[j][i] = 0;
    }
}