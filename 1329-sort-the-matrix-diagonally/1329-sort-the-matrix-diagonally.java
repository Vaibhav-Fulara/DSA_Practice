class Solution {
    public int[][] diagonalSort(int[][]arr) {
        int n = arr.length, m = arr[0].length;
        
        for(int i=0; i<n; i++){
            List<Integer>al = new ArrayList<Integer>();
            int k = i, j=0;
            while(k<n && j<m){
                al.add(arr[k][j]);
                k++; j++;
            }
            Collections.sort(al);
            
            j=0;
            int p=0;
            for(int o=i; o<k; o++){
                arr[o][j++] = al.get(p++);
            }
            
        }
        
        for(int j=1; j<m; j++){
            List<Integer>al = new ArrayList<Integer>();
            int k = j, i=0;
            while(k<m && i<n){
                al.add(arr[i][k]);
                k++; i++;
            }
            Collections.sort(al);
            
            i=0;
            int p=0;
            for(int o=j; o<k; o++){
                arr[i++][o] = al.get(p++);
            }
        }
        return arr;
    }
}