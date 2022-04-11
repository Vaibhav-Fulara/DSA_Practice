class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int[]arr = twoDtoOneD(grid);
        int[]rot = rotate(arr, k);
        List<List<Integer>>ans = new ArrayList<List<Integer>>();
        ans.add(new ArrayList<>());
        int n = grid[0].length, iter = 0, j=0;
        for(int val:rot){
            if(iter==n){
                ans.add(new ArrayList<>());
                iter = 0; j++;
            }
            ans.get(j).add(val);
            iter++;
        }
        return ans;
    }
    
    public int[] twoDtoOneD(int[][]arr){
        int [] ans = new int[arr.length * arr[0].length];
        int k=0;
        for(int i=0; i<arr.length; i++) for(int j=0; j<arr[0].length; j++) ans[k++] = arr[i][j];
        return ans;
    }
    
    public int[] rotate (int[]arr, int k){
        int n = arr.length;
        k%=n;
        int[]ans = new int[n];
        for(int i=0; i<n; i++) ans[(i+k)%n] = arr[i];
        return ans;
    }
}